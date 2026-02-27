package mars;

import interfaces.CommunicationSystem;
import interfaces.MissionComponent;
import interfaces.PowerSystem;
import interfaces.PropulsionSystem;
import interfaces.SciencePayload;

public class MarsFactory implements MissionComponent {

    @Override
    public PropulsionSystem createPropulsion() {
        return new MarsPropulsion(); 
    }

    @Override
    public PowerSystem createPowerSystem() {
        return new MarsPowerSystem();
    }

    @Override
    public SciencePayload createSciencePayload() {
        return new MarsScience();
    }

    @Override
    public CommunicationSystem createCommunicationSystem() {
        return new MarsCommunicationSystem();
    }

    @Override
    public String getMissionName() {
        return "Mars Exploration Mission (MEM-1)";
    }
}