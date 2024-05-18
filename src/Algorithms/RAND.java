package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;

import java.util.Random;

public class RAND implements replacementAlgorithm{
    @Override
    public int simulate(Page[] pageList, RAM ram) {
        ram.fillUp(pageList);
        int pageFaults = ram.getSize();
        int index = ram.getSize();
        Random random = new Random();

        for (int i = index; i<pageList.length; i++){
            if (!ram.contains(pageList[i].getValue())){
                pageFaults++;
                int indexToReplace = random.nextInt(0,ram.getSize());
                System.out.println("Swapped " + pageList[indexToReplace].getValue() +  " to " + pageList[i].getValue());
                ram.getFrames()[indexToReplace] = pageList[i];
            }
        }
        System.out.println();
        System.out.print("Page Faults: ");
        ram.clear();

        return pageFaults;
    }
}
