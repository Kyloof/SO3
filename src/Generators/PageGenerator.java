package Generators;

import MemoryStructures.Page;

import java.util.Random;

public class PageGenerator {
    public static Page[] generatePages(int size, int bound){
        Random random = new Random();
        Page[] pageList = new Page[size];
        for (int i = 0; i < size; i++){
            Page newPage = new Page(i+1, random.nextInt(0,bound));
            pageList[i] = newPage;
        }
        return pageList;
    }

    public static Page generatePage(int bound, int size){
        Random random = new Random();

        return new Page(1, random.nextInt(bound,bound+size));

    }
}
