package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;

import java.util.LinkedList;

public class LRUapprox implements replacementAlgorithm{

    @Override
    public int simulate(Page[] pageList, RAM ram) {
        LinkedList<Page> queue = new LinkedList<>();

        ram.fillUp(pageList);
        int pageFaults = ram.getSize();
        int index = ram.getSize();

        for(int i = 0; i< ram.getSize();i++){
            queue.addLast(ram.getFrames()[i]);
        }



        for(int i = index; i < pageList.length; i++){
            if (ram.contains(pageList[i].getValue())){
                for (Page page : queue){
                    if (page.getValue() == pageList[i].getValue()){
                        page.setReferenceBit(1);
                    }
                }
            }
            else{
                pageFaults++;
                Page currentPage;
                while (true){
                    currentPage = queue.removeFirst();

                    if (currentPage.getReferenceBit()==0){
                        break;
                    }
                    currentPage.setReferenceBit(0);
                    queue.addLast(currentPage);
                }
                queue.addLast(pageList[i]);
                Integer getIndex = ram.getIndex(currentPage.getValue());
                if (getIndex==null){
                    getIndex = ram.getIndex(currentPage.getValue());
                }
                ram.getFrames()[getIndex] = pageList[i];
            }
        }
        return pageFaults;
    }
}
