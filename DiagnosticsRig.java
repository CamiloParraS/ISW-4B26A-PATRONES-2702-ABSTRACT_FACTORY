public class DiagnosticsRig {

    private PropulsionSystem propulsion;
    private SensorSuite sensors;

    public DiagnosticsRig(SpacecraftEngineeringBay engineeringBay) {
        this.propulsion = engineeringBay.buildPropulsion();
        this.sensors = engineeringBay.buildSensors();
    }

    public void runFullSystemTest() {
        System.out.println("Initiating hardware diagnostic sequence...");
        propulsion.engage();
        sensors.scanEnvironment();
        System.out.println("Diagnostic complete. Systems nominal.\n");
    }
}
