package MemoryStructures;

import Algorithms.LRU;
import Generators.PageGenerator;

import java.util.ArrayList;

public class Process {
    int id;
    ArrayList<Page> pageList;
    public int size;
    int bound;
    RAM ram;
    LRU lru = new LRU();
    int pageFaults = 0;

    public Process(int size, int noElements, int bound, int id){
        this.size=size;
        this.id = id;
        this.pageList = new ArrayList<>();
        for (int i = 0; i < noElements; i++){
            pageList.add(PageGenerator.generatePage(bound,size));
        }
    }

    public void setRam(RAM ram){
        this.ram = ram;
    }

    public int simulate(int timeUnit){
        System.out.println("Process size: " + size);
        System.out.println("RAM allocation: " + ram.getSize());
        if (lru.simulateOneTU(pageList,ram,timeUnit, size)){
            this.pageFaults++;
        }
        System.out.println("Process " + id);
        ram.showRam();
        return pageFaults;
    }



}
