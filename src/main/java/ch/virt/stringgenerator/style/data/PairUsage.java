package ch.virt.stringgenerator.style.data;

/**
 * This class holds track of usages of pairs in words
 * @author VirtCode
 * @version 1.0
 */
public class PairUsage extends Usage{
    private char first;
    private char second;

    /**
     * Creates a pair
     * @param first first letter of the pair
     * @param second second letter of the pair
     */
    public PairUsage(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first letter of the pair
     * @return first letter
     */
    public char getFirst() {
        return first;
    }

    /**
     * Returns the second letter of the pair
     * @return second letter
     */
    public char getSecond() {
        return second;
    }
}
