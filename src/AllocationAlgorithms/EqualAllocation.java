package AllocationAlgorithms;

import MemoryStructures.Process;
import MemoryStructures.RAM;

import java.util.ArrayList;

public class EqualAllocation {
    RAM ram;
    RAM processRam;
    ArrayList<Process> processes;
    int framesPerProcess;
    public EqualAllocation(RAM ram, ArrayList<Process> processes){
        this.ram = ram;
        this.framesPerProcess = ram.getSize()/processes.size();
        this.processes = processes;
    }

    public int simulate(int time){
        int e = 750;
        int pageFaults = 0;

        for (Process process : processes){
            process.setRam(new RAM(framesPerProcess));
        }


        for (int i = 0; i < time; i ++){
            for (Process process : processes){
                pageFaults += process.simulate(i);
            }
        }

        System.out.println("Page faults: " + pageFaults);
        System.out.println("szamotanie limit: " + e);


        return pageFaults;
    }



}
