package ch.virt.stringgenerator.generation;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.data.CharacterUsage;
import ch.virt.stringgenerator.style.data.PairUsage;
import ch.virt.stringgenerator.style.data.Usage;

import java.util.Random;

/**
 * @author VirtCode
 * @version 1.0
 */
public class UsageHandler {

    private Style style;
    private Random random;

    private boolean unweighted = false;

    public UsageHandler(Style style) {
        this.style = style;
        this.random = new Random();
    }

    public void setWeighted(boolean weighted) {
        this.unweighted = !weighted;
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
        return getSecondFromRandom(first, style.getPairs(), random);
    }

    protected int getLength(){
        return getLength(random.nextDouble());
    }
    protected int getLength(double random){
        return style.getLengths()[getIndexFromRandom(random, style.getLengths())].getLength();
    }

    private char getSecondFromRandom(char first, PairUsage[] usages, double random){
        if (unweighted){
            int rand = (int) Math.floor(getSecondPairCount(first, usages) * random);
            int current = 0;

            for (PairUsage usage : usages) {
                if (usage.getFirst() == first){
                    current++;
                    if (current == rand) return usage.getSecond();
                }
            }

            return ' ';
        }

        int all = getSecondPairUsages(first, usages);
        int usage = (int) Math.floor(random * all);

        int current = 0;
        for (int i = 0; i < usages.length; i++) {
            if (usages[i].getFirst() == first){
                current += usages[i].getUsage();
                if (current >= usage) return usages[i].getSecond();
            }
        }

        return ' ';
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
