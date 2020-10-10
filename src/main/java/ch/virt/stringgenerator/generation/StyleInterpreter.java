package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.data.CombinationUsage;
import ch.virt.stringgenerator.style.data.PairUsage;
import ch.virt.stringgenerator.style.data.Usage;

import java.util.Random;

/**
 * This class performs various different operations with a style
 * @author VirtCode
 * @version 1.0
 */
public class StyleInterpreter {

    private Style style;
    private Random random;

    private boolean unweighted = false;

    /**
     * Creates a Style interpreter
     * @param style style to use
     */
    public StyleInterpreter(Style style) {
        this.style = style;
        this.random = new Random();
    }

    /**
     * Sets whether the selections should be weighted on the usage
     * (Default: True)
     * @param weighted is weighted
     */
    public void setWeighted(boolean weighted) {
        this.unweighted = !weighted;
    }
    /**
     * Sets the random used for the selection
     * @param random random used
     */
    public void setRandom(Random random) {
        this.random = random;
    }
    /**
     * Returns the random used for the selection
     * @return random used
     */
    public Random getRandom() {
        return random;
    }
    /**
     * Sets the style used
     * @param style style used
     */
    public void setStyle(Style style) {
        this.style = style;
    }
    /**
     * Returns the style used
     * @return style used
     */
    public Style getStyle() {
        return style;
    }

    /**
     * selects a random letter
     * @return letter
     */
    protected char getLetter(){
        return getLetter(random.nextDouble());
    }
    /**
     * selects a letter based on a random number
     * @param random random double (0 - 1)
     * @return letter
     */
    protected char getLetter(double random){
        return style.getLetters()[getIndexFromRandom(random, style.getLetters())].getCharacter();
    }

    /**
     * selects a random beginning letter
     * @return beginning letter
     */
    protected char getBeginning() {
        return getBeginning(random.nextDouble());
    }
    /**
     * Selects a beginning letter based on a random number
     * @param random random double (0 - 1)
     * @return beginning letter
     */
    protected char getBeginning(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    /**
     * Selects a random ending letter
     * @return ending letter
     */
    protected char getEnding(){
        return getEnding(random.nextDouble());
    }
    /**
     * Selects a ending letter based on a random number
     * @param random random double (0 - 1)
     * @return ending letter
     */
    protected char getEnding(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    /**
     * Selects a random second character in a pair based on the first
     * @param first first character to base on
     * @return second character
     */
    protected char getSecondPair(char first){
        return getSecondPair(first, random.nextDouble());
    }
    /**
     * Selects a second character in a pair based on the first and random number
     * @param first first character
     * @param random random double (0 - 1)
     * @return second character
     */
    protected char getSecondPair(char first, double random){
        return getSecond(first, style.getPairs(), random);
    }

    /**
     * Selects a random length in characters
     * @return selected length
     */
    protected int getLength(){
        return getLength(random.nextDouble());
    }
    /**
     * Selects a length in characters based on a random number
     * @param random random double (0 - 1)
     * @return length
     */
    protected int getLength(double random){
        return style.getLengths()[getIndexFromRandom(random, style.getLengths())].getLength();
    }

    /**
     * Selects a random vowel combination length in characters
     * @return vowel combination length
     */
    protected int getVowelCombinationLength(){
        return getVowelCombinationLength(random.nextDouble());
    }
    /**
     * Selects a vowel combination length in characters based on a random number
     * @param random random double (0 - 1)
     * @return vowel combination length
     */
    protected int getVowelCombinationLength(double random){
        return style.getVowelLengths()[getIndexFromRandom(random, style.getVowelLengths())].getLength();
    }

    /**
     * Selects a random non vowel combination length in characters
     * @return vowel combination length
     */
    protected int getNonVowelCombinationLength(){
        return getNonVowelCombinationLength(random.nextDouble());
    }
    /**
     * Selects a vowel combination length in characters based on a random number
     * @param random random double (0 - 1)
     * @return vowel combination length
     */
    protected int getNonVowelCombinationLength(double random){
        return style.getNonVowelLengths()[getIndexFromRandom(random, style.getNonVowelLengths())].getLength();
    }

    /**
     * Selects a random count of combinations
     * @return count of combinations
     */
    protected int getCombinationCount() {
        return getCombinationCount(random.nextDouble());
    }
    /**
     * Selects a count of combinations based on a random number
     * @param random random double (0 - 1)
     * @return count of combinations
     */
    protected int getCombinationCount(double random){
        return style.getCombinationCount()[getIndexFromRandom(random, style.getCombinationCount())].getLength();
    }

    /**
     * Selects a random vowel combination based on a random length
     * @return vowel combination
     */
    protected String getVowelCombinationByLength(){
        return getVowelCombinationByLength(getVowelCombinationLength());
    }
    /**
     * Selects a random vowel combination based on length
     * @param length length the combination should be
     * @return vowel combination
     */
    protected String getVowelCombinationByLength(int length) {
        return getVowelCombinationByLength(random.nextDouble(), length);
    }
    /**
     * Selects a vowel combination based on length and a random number
     * @param random random double (0 - 1)
     * @param length length the combination should be
     * @return vowel combinations
     */
    protected String getVowelCombinationByLength(double random, int length){
        return getCombination(random, style.getVowelCombinations(), length);
    }

    /**
     * Selects a random non vowel combination based on a random length
     * @return non vowel combination
     */
    protected String getNonVowelCombinationByLength(){
        return getNonVowelCombinationByLength(getNonVowelCombinationLength());
    }
    /**
     * Selects a random non vowel combination based on length
     * @param length length the combination should be
     * @return non vowel combination
     */
    protected String getNonVowelCombinationByLength(int length){
        return getNonVowelCombinationByLength(random.nextDouble(), length);
    }
    /**
     * Selects a non vowel combination based on length and a random number
     * @param random random double (0 - 1)
     * @param length length the combination should be
     * @return non vowel combinations
     */
    protected String getNonVowelCombinationByLength(double random, int length){
        return getCombination(random, style.getNonVowelCombinations(), length);
    }

    /**
     * Selects a random vowel combination based on total usage
     * @return vowel combination
     */
    protected String getVowelCombinationByUsage(){
        return getVowelCombinationByUsage(random.nextDouble());
    }
    /**
     * Selects a vowel combination based on total usage and a random number
     * @param random random double (0 - 1)
     * @return vowel combination
     */
    protected String getVowelCombinationByUsage(double random){
        return style.getVowelCombinations()[getIndexFromRandom(random, style.getVowelCombinations())].getCombination();
    }

    /**
     * Selects a random non vowel combination based on total usage
     * @return vowel combination
     */
    protected String getNonVowelCombinationByUsage(){
        return getNonVowelCombinationByUsage(random.nextDouble());
    }
    /**
     * Selects a non vowel combination based on total usage and a random number
     * @param random random double (0 - 1)
     * @return vowel combination
     */
    protected String getNonVowelCombinationByUsage(double random){
        return style.getNonVowelCombinations()[getIndexFromRandom(random, style.getNonVowelCombinations())].getCombination();
    }

    /**
     * Selects a random combination based on length
     * @param random random to choose with
     * @param usages usages to choose from
     * @param length length of desired combination
     * @return combination
     */
    private String getCombination(double random, CombinationUsage[] usages, int length){
        if (unweighted){
            int rand = (int) Math.floor(getCombinationUsageCount(usages, length) * random);
            int current = 0;

            for (CombinationUsage usage : usages) {
                if (usage.getLength() == length){
                    current++;
                    if (current == rand) return usage.getCombination();
                }
            }

            return "";
        }

        int all = getCombinationUsages(usages, length);
        int usage = (int) Math.floor(random * all);

        int current = 0;
        for (CombinationUsage combinationUsage : usages) {
            if (combinationUsage.getLength() == length){
                current += combinationUsage.getUsage();
                if (current >= usage) return combinationUsage.getCombination();
            }
        }

        return "";
    }

    /**
     * Returns the count of combinations with a defined length
     * @param usages usages to search through
     * @param length desired length
     * @return count of combinations
     */
    private int getCombinationUsageCount(CombinationUsage[] usages, int length){
        int u = 0;
        for (CombinationUsage usage : usages) {
            if (usage.getLength() == length) u++;
        }

        return u;
    }
    /**
     * Returns the combined usages of combinations with a defined length
     * @param usages usages to search through
     * @param length desired length
     * @return usages
     */
    private int getCombinationUsages(CombinationUsage[] usages, int length){
        int u = 0;
        for (CombinationUsage usage : usages) {
            if (usage.getLength() == length) u += usage.getUsage();
        }

        return u;
    }

    /**
     * Returns a random second character of a pair
     * @param first first character to return second to
     * @param usages usages to choose from
     * @param random random to choose with
     * @return chosen character
     */
    private char getSecond(char first, PairUsage[] usages, double random){
        if (unweighted){
            int rand = (int) Math.floor(getSecondPairCount(first, usages) * random) + 1;
            int current = 0;

            for (PairUsage usage : usages) {
                if (usage.getFirst() == first){
                    current++;
                    if (current == rand) return usage.getSecond();
                }
            }

            return getLetter(random);
        }

        int all = getSecondPairUsages(first, usages);
        int usage = (int) Math.floor(random * all);

        int current = 0;
        for (PairUsage pairUsage : usages) {
            if (pairUsage.getFirst() == first) {
                current += pairUsage.getUsage();
                if (current >= usage) return pairUsage.getSecond();
            }
        }

        return getLetter(random);
    }
    /**
     * Returns the combined amount of usages of pairs starting with that character
     * @param first first character of searched pairs
     * @param usages usages to search through
     * @return combined usages
     */
    private int getSecondPairUsages(char first, PairUsage[] usages){
        int u = 0;
        for (PairUsage usage : usages) {
            if (usage.getFirst() == first) u += usage.getUsage();
        }

        return u;
    }
    /**
     * Returns the combined count of usages of pairs starting with that character
     * @param first first character of searched pairs
     * @param usages usages to search through
     * @return count of pairs
     */
    private int getSecondPairCount(char first, PairUsage[] usages){
        int u = 0;
        for (PairUsage usage : usages) {
            if (usage.getFirst() == first) u++;
        }

        return u;
    }

    /**
     * Returns a random index of usages based on usage
     * @param random random to choose with
     * @param usages usages to use
     * @return index in the array
     */
    private int getIndexFromRandom(double random, Usage[] usages){
        if (unweighted){
            return (int) Math.floor(random * usages.length);
        }

        int all = getAllUsages(usages);
        int usage = (int) Math.floor(random * all);

        int current = 0;
        for (int i = 0; i < usages.length; i++) {
            current += usages[i].getUsage();
            if (current >= usage) return i;
        }

        return 0;
    }
    /**
     * Returns all usages contained in an array of usages
     * @param usages array of usages
     * @return amount of usages
     */
    private int getAllUsages(Usage[] usages){
        int u = 0;
        for (Usage usage : usages) {
            u += usage.getUsage();
        }

        return u;
    }
}
