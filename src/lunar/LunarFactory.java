package lunar;

import interfaces.MissionComponent;
import interfaces.PropulsionSystem;
import interfaces.PowerSystem;
import interfaces.SciencePayload;
import interfaces.CommunicationSystem;

public class LunarFactory implements MissionComponent {

    @Override
    public PropulsionSystem createPropulsion() {
        return new LunarPropulsion();
    }

    @Override
    public PowerSystem createPowerSystem() {
        return new LunarSolarPower();
    }

    @Override
    public SciencePayload createSciencePayload() {
        return new LunarScience();
    }

    @Override
    public CommunicationSystem createCommunicationSystem() {
        return new LunarCommunicationSystem();
    }

    @Override
    public String getMissionName() {
        return "Lunar Mission";
    }
}
