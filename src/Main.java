import Algorithms.*;
import Generators.PageGenerator;
import MemoryStructures.Page;
import MemoryStructures.RAM;

public class Main {

    public static Page[] createExampleList(){
        Page[] pageList = PageGenerator.generatePages(100, 20);
        int index = 0;
        int[] exampleValues = new int[]{1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        Page[] examplePages = new Page[12];
        for (int value : exampleValues) {
            examplePages[index] = new Page(index, value);
            index++;
        }
        return pageList;
    }
    public static void main(String[] args) {

        RAM ram = new RAM(4);


        //FIFO
        Page[] examplePages = createExampleList();

        System.out.println("FIFO");
        FIFO fifo = new FIFO();
        System.out.println();
        System.out.println(fifo.simulate(examplePages, ram));
        System.out.println("-------------------------------------------");


        //OPT
        examplePages = createExampleList();

        System.out.println("OPT");
        OPT opt = new OPT();
        System.out.println();
        System.out.println(opt.simulate(examplePages, ram));
        System.out.println("-------------------------------------------");

        //LRU
        examplePages = createExampleList();

        LRU lru = new LRU();
        System.out.println("LRU");
        System.out.println();
        System.out.println(lru.simulate(examplePages, ram));
        System.out.println("-------------------------------------------");



        //RAND
        examplePages = createExampleList();

        RAND rand = new RAND();
        System.out.println("RAND");
        System.out.println();
        System.out.println(rand.simulate(examplePages, ram));
        System.out.println("-------------------------------------------");


        //LRUapprox
        examplePages = createExampleList();

        LRUapprox lruApprox = new LRUapprox();
        System.out.println("LRUapprox");
        System.out.println();
        System.out.println(lruApprox.simulate(examplePages, ram));
        System.out.println("-------------------------------------------");


    }
}
