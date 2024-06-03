import AllocationAlgorithms.EqualAllocation;
import AllocationAlgorithms.ProportionalAllocation;
import Generators.ProcessGenerator;
import MemoryStructures.Process;
import MemoryStructures.RAM;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) {

        double avgEA = 0;
        double avgPA = 0;

        for (int i = 0; i < 100; i++){
            RAM ram = new RAM(20);
            int size = 10;
            ArrayList<Process> processes = ProcessGenerator.generateProcessList(4,size, 40);

            EqualAllocation EA = new EqualAllocation(ram,processes);
            ProportionalAllocation PA = new ProportionalAllocation(ram,processes);
            avgEA += EA.simulate(40);
        }








        for (int i = 0; i < 100; i++){
            RAM ram2 = new RAM(20);
            int size2 = 10;
            ArrayList<Process> processes2 = ProcessGenerator.generateProcessList(4,size2, 40);
            ProportionalAllocation PA = new ProportionalAllocation(ram2,processes2);
            avgPA += PA.simulate(40);
        }
        System.out.println(avgEA/100);
        System.out.println(avgPA/100);

    }
}
