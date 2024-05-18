package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;

public class OPT implements replacementAlgorithm{

    public int findNext(Page[] pageList, int index, RAM ram) {
        int indexToReplace = 0;
        int howSoon = 0;
        int nextIndex = 0;
        for (int j = 0; j < ram.getSize(); j++) {
            boolean isFound = false;
            Page page = ram.getFrames()[j];
            for (int i = index; i < pageList.length; i++) {
                if (pageList[i].getValue() == page.getValue()) {
                    isFound = true;
                    nextIndex = i;
                    break;
                }
            }
            if (!isFound){
                System.out.print("Swapped " + pageList[j].getValue());
                return j;
            }
            else if (howSoon < nextIndex - index) {
                indexToReplace = j;
                howSoon = nextIndex - index;
            }
        }
        System.out.print("Swapped " + pageList[indexToReplace].getValue());
        return indexToReplace;
    }

    @Override
    public int simulate(Page[] pageList, RAM ram) {

        ram.fillUp(pageList);
        int pageFaults = ram.getSize();
        int index = ram.getSize();

        for (int i = index; i<pageList.length; i++){
            if (!ram.contains(pageList[i].getValue())){
                pageFaults++;
                int indexToReplace = findNext(pageList,i,ram);
                System.out.println(" to " + pageList[i].getValue());

                ram.getFrames()[indexToReplace] = pageList[i];
            }
        }
        System.out.println();
        System.out.print("Page Faults: ");
        ram.clear();
        return pageFaults;
    }
}
