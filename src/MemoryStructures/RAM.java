package MemoryStructures;

import java.util.Arrays;

public class RAM {
    private final int size;
    private Page[] frames;
    private int cursor = 0;

    public RAM(int size){
        this.size = size;
        this.frames = new Page[size];
    }

    public int getSize() {
        return size;
    }

    public boolean contains(int value){
        for (int i = 0; i < cursor; i ++){
            Page page = frames[i];
            if (page.getValue() == value){
                return true;
            }
        }
        return false;
    }

    public int update(){
        int index = 0;
        for (int i = 0; i<cursor; i++){
            frames[i].setWaiting_time(frames[i].getWaiting_time()+1);
        }
        return index;
    }

    public void addPage(Page page){
        frames[cursor] = page;
        cursor++;
    }
    public void clear(){
        this.frames = new Page[size];
        this.cursor = 0;
    }

    public void fillUp(Page[] pageList){
        int index = 0;
        int pageFaults = 0;

        while(isFull()){
            if (!contains(pageList[index].getValue())){
                addPage(pageList[index]);
                pageFaults++;
            }
            index++;
            update();
        }
    }

    public Integer getIndex(int value){
        for (int i = 0; i < cursor; i ++){
            Page page = frames[i];
            if (page.getValue() == value){
                return i;
            }
        }
        return null;
    }

    public int getIndexMaxWaitTime(){
        int index = 0;
        for (int i = 0; i<cursor; i++){
            if (frames[i].getWaiting_time() > frames[index].getWaiting_time()){
                index = i;
            }
        }
        return index;
    }

    public void showRam(){
        System.out.print("RAM state: ");
        showPages();
    }

    public void showPages(){

        System.out.print("| ");
        for (int i = 0; i < size; i++){
            if(frames[i]!=null){
                System.out.print(frames[i].getValue() + " | ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public Page[] getFrames() {
        return frames;
    }

    public boolean isFull() {
        return frames[size - 1] == null;
    }
}
