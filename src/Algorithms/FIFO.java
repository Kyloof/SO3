package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;



public class FIFO implements replacementAlgorithm{
    @Override
    public int simulate(Page[] pageList, RAM ram) {

        ram.fillUp(pageList);
        int pageFaults = ram.getSize();
        int index = ram.getSize();

        for (index = index; index < pageList.length; index++){
            if (!ram.contains(pageList[index].getValue())){
                pageFaults++;
                int maxWaitingTime = ram.getIndexMaxWaitTime();
                System.out.println("Swapped: " + ram.getFrames()[maxWaitingTime].getValue() + " to: " + pageList[index].getValue());
                ram.getFrames()[maxWaitingTime] = pageList[index];
            }
            ram.update();


        }
        System.out.println();
        System.out.print("Page Faults: ");
        ram.clear();

        return pageFaults;
    }
}
