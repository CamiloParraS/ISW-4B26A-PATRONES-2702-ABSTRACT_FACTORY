package lunar;

import interfaces.PowerSystem;

public class LunarSolarPower implements PowerSystem {
    private static final double BASE_OUTPUT = 5000.0; 

    @Override
    public double estimatePowerOutput(double durationHours) {
        double degradation = 1.0 - (durationHours / 1000.0) * 0.005;
        return BASE_OUTPUT * Math.max(degradation, 0.7); 
    }

    @Override
    public double getThermalManagementRating() { return 0.85; } 

    @Override
    public double getPowerDraw() { return 500.0; }

    @Override
    public String getName() { return "Lunar Solar Array (5kW)"; }
}
