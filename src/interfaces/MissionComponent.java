package interfaces;

public interface MissionComponent {
    PropulsionSystem createPropulsion();
    PowerSystem createPowerSystem();
    SciencePayload createSciencePayload();
    CommunicationSystem createCommunicationSystem();
    String getMissionName();
}
