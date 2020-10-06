package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class CombinationUsage extends Usage {
    String combination;

    public CombinationUsage(String combination) {
        this.combination = combination;
    }

    public String getCombination() {
        return combination;
    }

    public int getLength(){
        return combination.length();
    }
}
