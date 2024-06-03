package Generators;

import MemoryStructures.Process;

import java.util.ArrayList;
import java.util.Random;

public class ProcessGenerator {
    public static ArrayList<Process>  generateProcessList(int length, int size, int noElements){
        ArrayList<Process> processes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            Process process = new Process(random.nextInt(1,size-1), noElements, processes.size()*size, i);
            processes.add(process);
        }

        return processes;
    }
}
