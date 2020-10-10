package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;

import java.util.Random;

/**
 * This class is the base for every basic generator
 * @author VirtCode
 * @version 1.0
 */
public abstract class Generator extends StyleInterpreter {

    /**
     * Creates a generator
     * @param style style to generate with
     */
    public Generator(Style style) {
        super(style);
    }

    /**
     * Sets a seed for the random of the generator
     * @param seed seed for the random
     */
    public void setSeed(long seed){
        setRandom(new Random(seed));
    }

    /**
     * Generates a String
     * @return generated string
     */
    public abstract String generate();
    /**
     * Generates an array of strings
     * @param count length of array
     * @return generated strings
     */
    public String[] generateMultiple(int count){
        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            names[i] = generate();
        }

        return names;
    }
}
