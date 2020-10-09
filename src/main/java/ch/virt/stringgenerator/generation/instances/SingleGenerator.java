package ch.virt.stringgenerator.generation.instances;

import ch.virt.stringgenerator.generation.Generator;
import ch.virt.stringgenerator.style.Style;

import java.util.Random;

/**
 * @author VirtCode
 * @version 1.0
 */
public class SingleGenerator extends Generator {

    private int length = -1;
    private boolean useBeginning = true;
    private char beginning = 0;
    private boolean useEnding = true;
    private char ending = 0;

    public SingleGenerator(Style style) {
        super(style);
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setBeginningLetter(char beginning){
        this.beginning = beginning;
    }
    public void setUseBeginning(boolean useBeginning) {
        this.useBeginning = useBeginning;
    }
    public void setEndingLetter(char ending) {
        this.ending = ending;
    }
    public void setUseEnding(boolean useEnding) {
        this.useEnding = useEnding;
    }

    @Override
    public String generate() {
        int length = this.length;
        char beginning = this.beginning;
        char ending = this.ending;

        if (length == -1) length = getLength();
        if (beginning == 0){
            if (useBeginning) beginning = getBeginning();
            else beginning = getLetter();
        }
        if (ending == 0){
            if (useEnding) ending = getEnding();
            else ending = getLetter();
        }

        char[] chars = new char[length];
        chars[0] = beginning;
        chars[chars.length -1] = ending;

        for (int i = 1; i < chars.length - 1; i++) {
            chars[i] = getLetter();
        }

        return new String(chars);
    }
}
