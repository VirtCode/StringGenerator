package code.generation;

import code.learning.StyleData;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Generator {

    StyleData data;
    GenerationAlgorithm algorithm;

    int length;
    char first;

    /**
     * Create Generator with all arguments
     * @param style StyleData to generate with
     * @param length Length to generate with
     * @param first First letter to generate with
     * @param algorithm Algorithm to generate with
     */
    public Generator(StyleData style, int length, char first, GenerationAlgorithm algorithm){
        this.data = style;
        this.algorithm = algorithm;
        this.length = length;
        this.first = first;
    }

    /**
     * Create Generator with minimum arguments
     * @param styleData Style to generate with
     * @param algorithm Algorithm to generate with
     */
    public Generator(StyleData styleData,  GenerationAlgorithm algorithm){
        this(styleData, 0, ' ', algorithm);
    }

    /**
     * Set Generation style
     * @param data Style to set
     */
    public void setStyle(StyleData data){
        this.data = data;
    }

    /**
     * Set Generation algorithm
     * @param algorithm Algorithm to set
     */
    public void setAlgorithm(GenerationAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    /**
     * Length to set
     * @param length Length to set
     */
    public void setLength(int length){
        this.length = length;
    }

    /**
     * Character to set
     * @param c Character to set
     */
    public void setFirst(char c){
        this.first = c;
    }

    /**
     * Generate a certain amount of strings
     * @param amount Amount to generate
     * @return Strings generated
     */
    public String[] generate(int amount){
        String[] ss = new String[amount];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = algorithm.generate(data, length, first);
        }
        return ss;
    }

    /**
     * Generate a String
     * @return String generated
     */
    public String generate(){
        return algorithm.generate(data, length, first);
    }
}
