package lunar;

import interfaces.SciencePayload;

public class LunarScience implements SciencePayload {
    @Override
    public String collectData() {
        return "Collected: surface spectroscopy, regolith samples, seismic readings";
    }

    @Override
    public double getDataVolumeGB()
    { 
        return 12.5; 
    }

    @Override
    public double getRadiationHardeningLevel() { return 0.6; } // moderate — Van Allen belts nearby

    @Override
    public double getPowerDraw()              { return 800.0; } // watts

    @Override
    public String getName() { return "Lunar Surface Science Package"; }
}
