package mars;

import interfaces.PropulsionSystem;

public class MarsPropulsion implements PropulsionSystem {

    private static final double ISP = 3000.0; // High efficiency ISP
    private static final double G0 = 9.81;

    @Override
    public double calculateDeltaV(double spacecraftMass) {
        double fuelMass = getFuelMassRequired(spacecraftMass);
        return (
            ISP * G0 * Math.log((spacecraftMass + fuelMass) / spacecraftMass)
        );
    }

    @Override
    public double getSpecificImpulse() {
        return ISP;
    }

    @Override
    public double getFuelMassRequired(double dryMass) {
        return dryMass * 0.10; // 10% fuel-to-weight ratio
    }

    @Override
    public String getName() {
        return "Mars Thruster";
    }
}
