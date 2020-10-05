package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Usage {
    private int usage;

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public void pushUsage(){
        usage++;
    }
}
