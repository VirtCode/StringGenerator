package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class LengthUsage {
    private int length;
    private int usage;

    public LengthUsage(int length) {
        this.length = length;
    }

    public LengthUsage(){}

    public int getLength() {
        return length;
    }

    public int getUsage() {
        return usage;
    }

    public void pushUsage(){
        usage++;
    }
}
