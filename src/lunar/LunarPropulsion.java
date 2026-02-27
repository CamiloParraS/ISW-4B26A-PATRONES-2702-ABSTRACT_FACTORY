package lunar;

import interfaces.PropulsionSystem;

public class LunarPropulsion implements PropulsionSystem {
    private static final double ISP = 450.0;   // seconds
    private static final double G0  = 9.81;    // m/s²

    @Override
    public double calculateDeltaV(double spacecraftMass) {
        double fuelMass = getFuelMassRequired(spacecraftMass);
        return ISP * G0 * Math.log((spacecraftMass + fuelMass) / spacecraftMass);
    }

    @Override
    public double getSpecificImpulse() { return ISP; }

    @Override
    public double getFuelMassRequired(double dryMass) {
        return dryMass * 0.30;
    }

    @Override
    public String getName() { return "Lunar Propulsion"; }
}
