package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class CharacterUsage {
    private int length;
    private int usage;

    public CharacterUsage(int length) {
        this.length = length;
    }

    public CharacterUsage(){}

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
