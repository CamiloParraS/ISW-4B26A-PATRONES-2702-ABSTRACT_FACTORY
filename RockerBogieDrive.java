public class RockerBogieDrive implements PropulsionSystem {

    @Override
    public void engage() {
        System.out.println(
            "Propulsion: Rocker-bogie wheels engaging. Kicking up red dust at 0.1 mph."
        );
    }
}
