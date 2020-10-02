package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class PairUsage {
    private char first;
    private char second;

    private int usage;

    public PairUsage(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public PairUsage(){}

    public char getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }

    public int getUsage() {
        return usage;
    }

    public void pushUsage()
    {
        usage++;
    }
}
