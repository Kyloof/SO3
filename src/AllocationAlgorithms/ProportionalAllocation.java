package AllocationAlgorithms;

import MemoryStructures.Process;
import MemoryStructures.RAM;

import java.util.ArrayList;

public class ProportionalAllocation {
    RAM ram;
    RAM processRam;
    ArrayList<Process> processes;
    int framesPerProcess;
    int totalSize = 0;
    public ProportionalAllocation(RAM ram, ArrayList<Process> processes){
        this.ram = ram;
        this.processes = processes;
        for (Process process: processes){
            totalSize+=process.size;
        }
    }

    public int simulate(int time){
        int e = 750;
        int pageFaults = 0;

        for (Process process : processes){
            process.setRam(new RAM((int)((double)process.size / totalSize * ram.getSize())));
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
