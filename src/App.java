

import assembler.MissionAssembler;
import interfaces.MissionComponent;
import lunar.LunarFactory;
import mars.MarsFactory;

public class App {
    public static void main(String[] args) {

        MissionComponent[] missions = {
            new LunarFactory(),
            new MarsFactory()
        };

        double[] distances = { 0.0026, 1.52, 5.2 };  
        double[] durations = { 720,    8760, 43800 }; 

        for (int i = 0; i < missions.length; i++) {
            MissionAssembler assembler = new MissionAssembler(
                missions[i],
                1500.0,          
                durations[i],
                distances[i]
            );
            assembler.assembleMission();
        }
    }
}
