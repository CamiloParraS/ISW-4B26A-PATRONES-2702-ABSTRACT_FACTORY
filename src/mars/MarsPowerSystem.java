package mars;

import interfaces.PowerSystem;

public class MarsPowerSystem implements PowerSystem {

    @Override
    public double estimatePowerOutput(double durationHours) {
        double yearsElapsed = durationHours / 8760.0;
        return 500.0 * Math.pow(0.9935, yearsElapsed * 365);
    }

    @Override
    public double getThermalManagementRating() {
        return 0.70;
    }

    @Override
    public double getPowerDraw() {
        return 100.0;
    }

    @Override
    public String getName() {
        return "Multi-Mission";
    }
}