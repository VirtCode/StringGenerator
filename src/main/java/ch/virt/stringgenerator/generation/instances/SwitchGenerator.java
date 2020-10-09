package ch.virt.stringgenerator.generation.instances;

import ch.virt.stringgenerator.generation.Generator;
import ch.virt.stringgenerator.style.Style;

/**
 * @author VirtCode
 * @version 1.0
 */
public class SwitchGenerator extends Generator {

    private int partLength = -1;

    private boolean vowelStart;
    private boolean hasStart = false;

    private boolean useLengthWeight = true;

    public SwitchGenerator(Style style) {
        super(style);
    }

    public void setPartLength(int partLength) {
        this.partLength = partLength;
    }
    public void setVowelStart(boolean vowelStart) {
        this.vowelStart = vowelStart;
        hasStart = true;
    }
    public void setUseLengthWeight(boolean useLengthWeight) {
        this.useLengthWeight = useLengthWeight;
    }

    @Override
    public String generate() {
        boolean start = vowelStart;
        if (!hasStart) start = getRandom().nextBoolean();

        if (partLength == -1) partLength = getCombinationCount();
        if (partLength == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < partLength; i++) {
            if (start) sb.append(getVowel());
            else sb.append(getNonVowel());
            start = !start;
        }

        return sb.toString();
    }

    private String getVowel(){
        if (useLengthWeight) return getVowelCombinationByLength();
        else return getVowelCombinationByUsage();
    }

    private String getNonVowel(){
        if (useLengthWeight) return getNonVowelCombinationByLength();
        else return getNonVowelCombinationByUsage();
    }
}
