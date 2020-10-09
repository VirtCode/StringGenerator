package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.data.CombinationUsage;
import ch.virt.stringgenerator.style.data.PairUsage;
import ch.virt.stringgenerator.style.data.Usage;

import java.util.Random;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleInterpreter {

    private Style style;
    private Random random;

    private boolean unweighted = false;

    public StyleInterpreter(Style style) {
        this.style = style;
        this.random = new Random();
    }

    public void setWeighted(boolean weighted) {
        this.unweighted = !weighted;
    }
    public void setRandom(Random random) {
        this.random = random;
    }
    public Random getRandom() {
        return random;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
    public Style getStyle() {
        return style;
    }

    protected char getLetter(){
        return getLetter(random.nextDouble());
    }
    protected char getLetter(double random){
        return style.getLetters()[getIndexFromRandom(random, style.getLetters())].getCharacter();
    }

    protected char getBeginning() {
        return getBeginning(random.nextDouble());
    }
    protected char getBeginning(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    protected char getEnding(){
        return getEnding(random.nextDouble());
    }
    protected char getEnding(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    protected char getSecondPair(char first){
        return getSecondPair(first, random.nextDouble());
    }
    protected char getSecondPair(char first, double random){
        return getSecond(first, style.getPairs(), random);
    }

    protected int getLength(){
        return getLength(random.nextDouble());
    }
    protected int getLength(double random){
        return style.getLengths()[getIndexFromRandom(random, style.getLengths())].getLength();
    }

    protected int getVowelCombinationLength(){
        return getVowelCombinationLength(random.nextDouble());
    }
    protected int getVowelCombinationLength(double random){
        return style.getVowelLengths()[getIndexFromRandom(random, style.getVowelLengths())].getLength();
    }

    protected int getNonVowelCombinationLength(){
        return getNonVowelCombinationLength(random.nextDouble());
    }
    protected int getNonVowelCombinationLength(double random){
        return style.getNonVowelLengths()[getIndexFromRandom(random, style.getNonVowelLengths())].getLength();
    }

    protected int getCombinationCount(){
        return getCombinationCount(random.nextDouble());
    }
    protected int getCombinationCount(double random){
        return style.getCombinationCount()[getIndexFromRandom(random, style.getCombinationCount())].getLength();
    }

    protected String getVowelCombinationByLength(){
        return getVowelCombinationByLength(getVowelCombinationLength());
    }
    protected String getVowelCombinationByLength(int length) {
        return getVowelCombinationByLength(random.nextDouble(), length);
    }
    protected String getVowelCombinationByLength(double random, int length){
        return getCombination(random, style.getVowelCombinations(), length);
    }

    protected String getNonVowelCombinationByLength(){
        return getNonVowelCombinationByLength(getNonVowelCombinationLength());
    }
    protected String getNonVowelCombinationByLength(int length){
        return getNonVowelCombinationByLength(random.nextDouble(), length);
    }
    protected String getNonVowelCombinationByLength(double random, int length){
        return getCombination(random, style.getNonVowelCombinations(), length);
    }

    protected String getVowelCombinationByUsage(){
        return getVowelCombinationByUsage(random.nextDouble());
    }
    protected String getVowelCombinationByUsage(double random){
        return style.getVowelCombinations()[getIndexFromRandom(random, style.getVowelCombinations())].getCombination();
    }

    protected String getNonVowelCombinationByUsage(){
        return getNonVowelCombinationByUsage(random.nextDouble());
    }
    protected String getNonVowelCombinationByUsage(double random){
        return style.getNonVowelCombinations()[getIndexFromRandom(random, style.getNonVowelCombinations())].getCombination();
    }

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
    private int getCombinationUsageCount(CombinationUsage[] usages, int length){
        int u = 0;
        for (CombinationUsage usage : usages) {
            if (usage.getLength() == length) u++;
        }

        return u;
    }
    private int getCombinationUsages(CombinationUsage[] usages, int length){
        int u = 0;
        for (CombinationUsage usage : usages) {
            if (usage.getLength() == length) u += usage.getUsage();
        }

        return u;
    }

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
    private int getSecondPairUsages(char first, PairUsage[] usages){
        int u = 0;
        for (PairUsage usage : usages) {
            if (usage.getFirst() == first) u += usage.getUsage();
        }

        return u;
    }
    private int getSecondPairCount(char first, PairUsage[] usages){
        int u = 0;
        for (PairUsage usage : usages) {
            if (usage.getFirst() == first) u++;
        }

        return u;
    }

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
    private int getAllUsages(Usage[] usages){
        int u = 0;
        for (Usage usage : usages) {
            u += usage.getUsage();
        }

        return u;
    }
}
