package lunar;

import interfaces.CommunicationSystem;

public class LunarCommunicationSystem implements CommunicationSystem {

    @Override
    public double calculateSignalDelay(double distanceAU) {
        return distanceAU * 499.0;
    }

    @Override
    public double getMaxDataRate() { return 100.0; } 

    @Override
    public double getPowerDraw()   { return 200.0; } 

    @Override
    public String getName() { return "S-Band High-Gain Antenna"; }
}