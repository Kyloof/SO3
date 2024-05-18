package Algorithms;

import MemoryStructures.Page;
import MemoryStructures.RAM;

public interface replacementAlgorithm {
    public int simulate(Page[] pageList, RAM ram);
}
