package ch.virt.stringgenerator.generation.instances;

import ch.virt.stringgenerator.generation.Generator;
import ch.virt.stringgenerator.style.Style;

/**
 * @author VirtCode
 * @version 1.0
 */
public class PairGenerator extends Generator {

    int length = -1;
    char beginning = 0;

    public PairGenerator(Style style) {
        super(style);
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setBeginningLetter(char beginning){
        this.beginning = beginning;
    }

    @Override
    public String generateName() {
        char beginning = this.beginning;
        int length = this.length;
        if (beginning == 0){
            beginning = getBeginning();
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
