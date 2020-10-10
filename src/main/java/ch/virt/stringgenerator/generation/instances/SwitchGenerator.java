package ch.virt.stringgenerator.generation.instances;

import ch.virt.stringgenerator.generation.Generator;
import ch.virt.stringgenerator.style.Style;

/**
 * This is a Generator preset
 * This generator bases on using vowel and non vowel combinations and stitching them  together in alternating manners
 * @author VirtCode
 * @version 1.0
 */
public class SwitchGenerator extends Generator {

    private int partLength = -1;

    private boolean vowelStart;
    private boolean hasStart = false;

    private boolean useLengthWeight = true;

    /**
     * Creates the Generator
     * @param style style to generate with
     */
    public SwitchGenerator(Style style) {
        super(style);
    }

    /**
     * Sets the count of vowel or non vowel combinations the generator should generate the String with
     * @param partLength count of vowel or non vowel combinations
     */
    public void setPartLength(int partLength) {
        this.partLength = partLength;
    }
    /**
     * Sets whether the String should start with a vowel or non vowel combination
     * @param vowelStart whether to start with a vowel
     */
    public void setVowelStart(boolean vowelStart) {
        this.vowelStart = vowelStart;
        hasStart = true;
    }
    /**
     * Sets whether the generation should incorporate the length of the combinations or only their usages
     * @param useLengthWeight should incorporate length
     */
    public void setUseLengthWeight(boolean useLengthWeight) {
        this.useLengthWeight = useLengthWeight;
    }

    @Override
    public String generate() {
        boolean start = vowelStart;
        int length = partLength;
        if (!hasStart) start = getRandom().nextBoolean();

        if (length == -1) length = getCombinationCount();
        if (length == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (start) sb.append(getVowel());
            else sb.append(getNonVowel());
            start = !start;
        }

        return sb.toString();
    }

    /**
     * Returns a random vowel combination
     * @return vowel combination
     */
    private String getVowel(){
        if (useLengthWeight) return getVowelCombinationByLength();
        else return getVowelCombinationByUsage();
    }

    /**
     * Returns a random non vowel combination
     * @return non vowel combination
     */
    private String getNonVowel(){
        if (useLengthWeight) return getNonVowelCombinationByLength();
        else return getNonVowelCombinationByUsage();
    }
}
