package mars;

import interfaces.SciencePayload;

public class MarsScience implements SciencePayload {

    @Override
    public String collectData() {
        return "Collected: atmospheric samples, subsurface radar, methane detection";
    }

    @Override
    public double getDataVolumeGB() {
        return 50.0;
    }

    @Override
    public double getRadiationHardeningLevel() {
        // Mars has a thin atmosphere, requiring high radiation resistance
        return 0.85;
    }

    @Override
    public double getPowerDraw() {
        return 600.0;
    }

    @Override
    public String getName() {
        return "Mars Science Laboratory Package";
    }
}