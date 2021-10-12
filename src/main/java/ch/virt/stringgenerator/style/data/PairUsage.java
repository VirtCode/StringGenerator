package ch.virt.stringgenerator.style.data;

/**
 * This class holds track of usages of pairs in words
 * @author VirtCode
 * @version 1.0
 */
public class PairUsage extends Usage {

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
     * Constructor for deserialization
     */
    public PairUsage() {}


    /**
     * Sets the first letter to the pair
     * @param first first letter
     */
    public void setFirst(char first) {
        this.first = first;
    }

    /**
     * Sets the second letter to the pair
     * @param second second letter
     */
    public void setSecond(char second) {
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
