public class Main {

    public static void main(String[] args) {
        SpacecraftEngineeringBay roverBay = new SurfaceRoverBay();
        DiagnosticsRig roverTestRig = new DiagnosticsRig(roverBay);
        roverTestRig.runFullSystemTest();

        SpacecraftEngineeringBay probeBay = new DeepSpaceProbeBay();
        DiagnosticsRig probeTestRig = new DiagnosticsRig(probeBay);
        probeTestRig.runFullSystemTest();
    }
}
