package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class PairUsage extends Usage{
    private char first;
    private char second;


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
}
