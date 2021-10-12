package ch.virt.stringgenerator.style.data;

/**
 * This class holds the usage of a combination of characters
 * @author VirtCode
 * @version 1.0
 */
public class CombinationUsage extends Usage {

    private String combination;

    /**
     * Creates a combination storage
     * @param combination combination
     */
    public CombinationUsage(String combination) {
        this.combination = combination;
    }

    /**
     * Constructor for deserialization
     */
    public CombinationUsage() { }

    /**
     * Sets the combination string
     * @param combination combination string
     */
    public void setCombination(String combination) {
        this.combination = combination;
    }

    /**
     * Returns the combination
     * @return combination
     */
    public String getCombination() {
        return combination;
    }

    /**
     * Returns the length of that combination
     * @return length of combination
     */
    public int getLength(){
        return combination.length();
    }
}
