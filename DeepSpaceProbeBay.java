public class DeepSpaceProbeBay implements SpacecraftEngineeringBay {

    @Override
    public PropulsionSystem buildPropulsion() {
        return new IonThruster();
    }

    @Override
    public SensorSuite buildSensors() {
        return new RadioTelescope();
    }
}
