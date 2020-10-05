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

    public UsageHandler(Style style) {
        this.style = style;
        this.random = new Random();
    }

    public void setStyle(Style style) {
        this.style = style;
    }
    public Style getStyle() {
        return style;
    }

    public char getLetter(){
        return getLetter(random.nextDouble());
    }
    public char getLetter(double random){
        return style.getLetters()[getIndexFromRandom(random, style.getLetters())].getCharacter();
    }

    public char getBeginning() {
        return getBeginning(random.nextDouble());
    }
    public char getBeginning(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    public char getEnding(){
        return getEnding(random.nextDouble());
    }
    public char getEnding(double random){
        return style.getBeginnings()[getIndexFromRandom(random, style.getBeginnings())].getCharacter();
    }

    public char getSecondPair(char first){
        return getSecondPair(first, random.nextDouble());
    }
    public char getSecondPair(char first, double random){
        return getSecondFromRandom(first, style.getPairs(), random);
    }

    public int getLength(){
        return getLength(random.nextDouble());
    }
    public int getLength(double random){
        return style.getLengths()[getIndexFromRandom(random, style.getLengths())].getLength();
    }

    public char getSecondFromRandom(char first, PairUsage[] usages, double random){
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
    public int getSecondPairUsages(char first, PairUsage[] usages){
        int u = 0;
        for (PairUsage usage : usages) {
            if (usage.getFirst() == first) u += usage.getUsage();
        }

        return u;
    }

    public int getIndexFromRandom(double random, Usage[] usages){
        int all = getAllUsages(usages);
        int usage = (int) Math.floor(random * all);

        int current = 0;
        for (int i = 0; i < usages.length; i++) {
            current += usages[i].getUsage();
            if (current >= usage) return i;
        }

        return 0;
    }
    public int getAllUsages(Usage[] usages){
        int u = 0;
        for (Usage usage : usages) {
            u += usage.getUsage();
        }

        return u;
    }
}
