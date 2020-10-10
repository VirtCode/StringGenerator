package ch.virt.stringgenerator.generation.instances;

import ch.virt.stringgenerator.generation.Generator;
import ch.virt.stringgenerator.style.Style;

/**
 * This is a Generator preset
 * This generator uses pairs to select characters that are in relation to each other
 * @author VirtCode
 * @version 1.0
 */
public class PairGenerator extends Generator {

    private int length = -1;
    private char beginning = 0;
    private boolean useBeginning = true;

    /**
     * Creates a pair generator
     * @param style style to generate with
     */
    public PairGenerator(Style style) {
        super(style);
    }

    /**
     * Sets the length of the String that should be generated
     * @param length length in characters
     */
    public void setLength(int length){
        this.length = length;
    }

    /**
     * Sets the beginning letter of the string
     * @param beginning beginning character
     */
    public void setBeginningLetter(char beginning){
        this.beginning = beginning;
    }
    /**
     * Sets whether the generator should use the dedicated beginning letter dataset
     * @param useBeginning use specific beginning letters
     */
    public void setUseBeginning(boolean useBeginning) {
        this.useBeginning = useBeginning;
    }

    @Override
    public String generate() {
        char beginning = this.beginning;
        int length = this.length;
        if (beginning == 0){
            if (useBeginning) beginning = getBeginning();
            else beginning = getLetter();
        }
        if (length < 0){
            length = getLength();
        }

        if (length == 0) return "";

        char[] chars = new char[length];
        chars[0] = beginning;
        for (int i = 1; i < chars.length; i++) {
            chars[i] = getSecondPair(chars[i - 1]);
        }

        return new String(chars);
    }
}
