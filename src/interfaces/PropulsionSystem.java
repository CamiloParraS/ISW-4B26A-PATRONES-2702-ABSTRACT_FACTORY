package interfaces;

public interface PropulsionSystem {
    double calculateDeltaV(double spacecraftMass);
    double getSpecificImpulse();
    double getFuelMassRequired(double dryMass);
    String getName();
}
