package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;

import java.util.Random;

/**
 * @author VirtCode
 * @version 1.0
 */
public abstract class Generator extends StyleInterpreter {

    public Generator(Style style) {
        super(style);
    }

    public void setSeed(long seed){
        setRandom(new Random(seed));
    }

    public abstract String generate();
    public String[] generateMultiple(int count){
        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            names[i] = generate();
        }

        return names;
    }
}
