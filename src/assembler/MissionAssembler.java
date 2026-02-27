package assembler;

import interfaces.CommunicationSystem;
import interfaces.PowerSystem;
import interfaces.PropulsionSystem;
import interfaces.SciencePayload;
import interfaces.MissionComponent;

public class MissionAssembler {
    private final MissionComponent factory;

    private final double spacecraftDryMass;   // kg
    private final double missionDurationHours;
    private final double distanceFromEarthAU;

    public MissionAssembler(MissionComponent factory,
                            double spacecraftDryMass,
                            double missionDurationHours,
                            double distanceFromEarthAU) {
        this.factory = factory;
        this.spacecraftDryMass = spacecraftDryMass;
        this.missionDurationHours = missionDurationHours;
        this.distanceFromEarthAU = distanceFromEarthAU;
    }

    public void assembleMission() {
        System.out.println("  ASSEMBLING: " + factory.getMissionName());

        PropulsionSystem    propulsion = factory.createPropulsion();
        PowerSystem         power      = factory.createPowerSystem();
        SciencePayload      payload    = factory.createSciencePayload();
        CommunicationSystem comms      = factory.createCommunicationSystem();

        // --- Print component selection ---
        System.out.println("[ COMPONENTS SELECTED ]");
        System.out.println("  Propulsion : " + propulsion.getName());
        System.out.println("  Power      : " + power.getName());
        System.out.println("  Payload    : " + payload.getName());
        System.out.println("  Comms      : " + comms.getName());
        System.out.println();

        // --- Propulsion calculations ---
        double fuelMass  = propulsion.getFuelMassRequired(spacecraftDryMass);
        double totalMass = spacecraftDryMass + fuelMass;
        double deltaV    = propulsion.calculateDeltaV(spacecraftDryMass);

        System.out.println("[ PROPULSION BUDGET ]");
        System.out.printf("  Dry mass        : %.0f kg%n",  spacecraftDryMass);
        System.out.printf("  Fuel required   : %.0f kg%n",  fuelMass);
        System.out.printf("  Total mass      : %.0f kg%n",  totalMass);
        System.out.printf("  Delta-V achieved: %.1f m/s%n", deltaV);
        System.out.println();

        // --- Power budget validation ---
        double powerAvailable = power.estimatePowerOutput(missionDurationHours);
        double powerNeeded    = power.getPowerDraw()
                              + payload.getPowerDraw()
                              + comms.getPowerDraw();

        System.out.println("[ POWER BUDGET ]");
        System.out.printf("  Power available : %.1f W%n",  powerAvailable);
        System.out.printf("  Power needed    : %.1f W%n",  powerNeeded);
        System.out.printf("  Power margin    : %.1f W%n",  powerAvailable - powerNeeded);

        if (powerAvailable < powerNeeded) {
            System.out.println("  *** MISSION INFEASIBLE: Power budget exceeded! ***");
            System.out.println("\n  Assembly FAILED.");
            return;
        } else {
            System.out.println("  Power budget: OK ");
        }
        System.out.println();

        // --- Communications report ---
        double signalDelay = comms.calculateSignalDelay(distanceFromEarthAU);
        System.out.println("[ COMMUNICATIONS ]");
        System.out.printf("  Distance        : %.2f AU%n",      distanceFromEarthAU);
        System.out.printf("  Signal delay    : %.1f seconds%n", signalDelay);
        System.out.printf("  Max data rate   : %.1f Mbps%n",    comms.getMaxDataRate());
        System.out.printf("  Est. data vol.  : %.1f GB%n",      payload.getDataVolumeGB());

        double downloadHours = (payload.getDataVolumeGB() * 8192.0)
                             / (comms.getMaxDataRate() * 60.0 * 60.0);
        System.out.printf("  Download time   : %.1f hours%n",   downloadHours);
        System.out.println();

        // --- Radiation check ---
        System.out.println("[ RADIATION ASSESSMENT ]");
        System.out.printf("  Payload hardening   : %.0f%%%n",
                payload.getRadiationHardeningLevel() * 100);
        System.out.printf("  Thermal rating      : %.0f%%%n",
                power.getThermalManagementRating() * 100);
        System.out.println();

        // --- Science summary ---
        System.out.println("[ SCIENCE OUTPUT ]");
        System.out.println("  " + payload.collectData());
        System.out.println();

        System.out.println("  Mission assembly SUCCESSFUL ");
        System.out.println("=".repeat(50));
    }
}
