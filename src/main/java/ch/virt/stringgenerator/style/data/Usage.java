package ch.virt.stringgenerator.style.data;

/**
 * This class keeps track of the usage of occurrences
 * @author VirtCode
 * @version 1.0
 */
public class Usage {
    private int usage;

    /**
     * Constructor for deserialization
     */
    public Usage() { }

    /**
     * Returns the total count of usages
     * @return count of usages
     */
    public int getUsage() {
        return usage;
    }

    /**
     * Sets the total count of usages
     * @param usage count of usages
     */
    public void setUsage(int usage) {
        this.usage = usage;
    }

    /**
     * Increases the count of usages by one
     */
    public void pushUsage(){
        usage++;
    }
}
