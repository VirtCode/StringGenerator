package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;

/**
 * @author VirtCode
 * @version 1.0
 */
public abstract class Generator extends UsageHandler{

    public Generator(Style style) {
        super(style);
    }

    public abstract String generateName();
    public String[] generateNames(int count){
        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            names[i] = generateName();
        }

        return names;
    }
}
