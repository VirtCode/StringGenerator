package ch.virt.stringgenerator.style.data;

/**
 * This class stores the usage of lengths
 * @author VirtCode
 * @version 1.0
 */
public class LengthUsage extends Usage{

    private int length;

    /**
     * Creates a length storage
     * @param length length the storage counts on
     */
    public LengthUsage(int length) {
        this.length = length;
    }

    /**
     * Constructor for deserialization
     */
    public LengthUsage() { }

    /**
     * Sets the length
     * @param length length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the length
     * @return length
     */
    public int getLength() {
        return length;
    }
}
