package interfaces;

public interface CommunicationSystem {
    double calculateSignalDelay(double distanceAU);
    double getMaxDataRate();
    double getPowerDraw();
    String getName();
}
