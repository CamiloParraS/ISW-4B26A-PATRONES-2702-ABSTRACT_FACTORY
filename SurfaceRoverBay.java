public class SurfaceRoverBay implements SpacecraftEngineeringBay {

    @Override
    public PropulsionSystem buildPropulsion() {
        return new RockerBogieDrive();
    }

    @Override
    public SensorSuite buildSensors() {
        return new SpectrometerDrill();
    }
}
