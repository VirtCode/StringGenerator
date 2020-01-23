package ch.virt.stringgenerator.algorithms;

import ch.virt.stringgenerator.Style;
import ch.virt.stringgenerator.Utilizer;

import java.util.Random;

/**
 * Template for generation Algorithms
 * @author VirtCode
 * @version 1.0
 */
public abstract class GenerationAlgorithm {

    Utilizer utilizer;

    int length;

    char first;

    /**
     * Generate a String
     * @param styleData StyleData to generate with
     * @param length Length of String
     * @param first First char of String
     * @return Generated String
     */
    public String generate(Style styleData, int length, char first){
        this.utilizer = new Utilizer(styleData);
        this.length = length;
        this.first = first;

        return generate();
    }

    /**
     * Induvidual function of Algorithms
     * @return Generated String
     */
    protected abstract String generate();

    /**
     * Returns pseudorandom int between 0(incl.) and range(excl.)
     * @param range Maximum (excluded)
     * @return Pseudorandom integer
     */
    protected int randInt(int range){
        Random random = new Random();
        return random.nextInt(range);
    }

    /**
     * Returns a Pseudorandom Vowel based on Usage
     * @return Pseudorandom Vowel
     */
    protected char randomVowel(){
        int range = utilizer.getWholeVowelUses();
        return utilizer.getVowelAt(randInt(range));
    }

    /**
     * Returns a Pseudorandom Consonant based on Usage
     * @return Pseudorandom Consonant
     */
    protected char randomConsonant(){
        int range = utilizer.getWholeConsonantUses();
        return utilizer.getConsonantAt(randInt(range));
    }

    /**
     * Returns Pseudorandom second of pair for character
     * @param c first character of pair
     * @return Pseudorandom second
     */
    protected char randomSecond(char c){
        int range = utilizer.getPairsFor(c);
        return utilizer.getSecondForAt(c, randInt(range));
    }

    /**
     * Returns a Pseudorandom vowelcombination
     * @return Pseudorandom vowelcombination
     */
    protected String randomVowelCombination(){
        int range = utilizer.getWholeVowelCombination();
        return utilizer.getVowelCombinationAt(randInt(range));
    }

    /**
     * Returns a Pseudorandom consonantcombination
     * @return Pseudorandom consonantcombination
     */
    protected String randomConsonantCombination(){
        int range = utilizer.getWholeConsonantCombinations();
        return utilizer.getConsonantCombinationAt(randInt(range));
    }

    /**
     * Returns pseudorandomly if it is a Combination of a Single
     * @return true is a combo
     */
    protected boolean randomAmountForConsonant(){
        int range = utilizer.getWholeConsonantLength();
        return utilizer.isConsonantComboAt(randInt(range));
    }

    /**
     * Returns pseudorandomly if it is a Combination of a Single
     * @return true is a combo
     */
    protected boolean randomAmountForVowel(){
        int range = utilizer.getWholeVowelLength();
        return utilizer.isVowelComboAt(randInt(range));
    }

    /**
     * Returns a pseudorandom amount of Consonants
     * @return Consonants
     */
    protected String randomConsonants() {
        if (randomAmountForConsonant()){
            return randomConsonantCombination();
        }else{
            return "" + randomConsonant();
        }
    }

    /**
     * Returns a pseudorandom amount of Vowels
     * @return Vowels
     */
    protected String randomVowels() {
        if (randomAmountForVowel()){
            return randomVowelCombination();
        }else{
            return "" + randomVowel();
        }
    }
}
