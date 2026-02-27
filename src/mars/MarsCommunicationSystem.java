package mars;

import interfaces.CommunicationSystem;

public class MarsCommunicationSystem implements CommunicationSystem {

    @Override
    public double calculateSignalDelay(double distanceAU) {
        return distanceAU * 499.0;
    }

    @Override
    public double getMaxDataRate() {
        return 2.0;
    }

    @Override
    public double getPowerDraw() {
        return 400.0;
    }

    @Override
    public String getName() {
        return "Deep Space Antenna";
    }
}