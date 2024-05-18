package MemoryStructures;

public class Page {

    private int id;
    private int waiting_time;
    private int value;
    private int referenceBit = 1;

    public Page(int id, int value){
        this.id = id;
        this.waiting_time = 0;
        this.value = value;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public int getId() {
        return id;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getReferenceBit() {
        return referenceBit;
    }

    public void setReferenceBit(int referenceBit) {
        this.referenceBit = referenceBit;
    }
}
