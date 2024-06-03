package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;

import java.util.ArrayList;

public class LRU implements replacementAlgorithm{
    @Override
    public int simulate(Page[] pageList, RAM ram) {
        ram.fillUp(pageList);
        int pageFaults = ram.getSize();
        int index = ram.getSize();

        for (index = index; index < pageList.length; index++){
            Integer getIndex = ram.getIndex(pageList[index].getValue());
            if (getIndex ==null){
                pageFaults++;
                int maxWaitingTime = ram.getIndexMaxWaitTime();
                System.out.println("Swapped: " + ram.getFrames()[maxWaitingTime].getValue() + " to: " + pageList[index].getValue());
                ram.getFrames()[maxWaitingTime] = pageList[index];
            }
            else{
                ram.getFrames()[getIndex].setWaiting_time(0);
            }
            ram.update();


        }
        System.out.println();
        System.out.print("Page Faults: ");
        ram.clear();

        return pageFaults;
    }

    public boolean simulateOneTU(ArrayList<Page> pageList, RAM ram, int timeUnit, int size) {


        for (int i = 0; i < ram.getSize(); i++){
            if (ram.getFrames()[i] == null){
                ram.addPage(pageList.get(timeUnit));
                return false;
            }
        }

        Integer getIndex = ram.getIndex(pageList.get(timeUnit).getValue());

        if (getIndex == null){
            int maxWaitingTime = ram.getIndexMaxWaitTime();
            ram.getFrames()[maxWaitingTime] = pageList.get(timeUnit);

            return true;
        }
        else{
            ram.getFrames()[getIndex].setWaiting_time(0);
            return false;
        }

    }


}
