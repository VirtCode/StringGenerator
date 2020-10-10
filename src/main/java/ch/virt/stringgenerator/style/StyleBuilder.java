package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.*;

import java.util.ArrayList;

/**
 * This class is used to build new Styles
 * @author VirtCode
 * @version 1.0
 */
public class StyleBuilder {

    private ArrayList<LengthUsage> lengths;
    private ArrayList<CharacterUsage> letters;
    private ArrayList<PairUsage> pairs;

    private ArrayList<CharacterUsage> beginnings;
    private ArrayList<CharacterUsage> ends;

    private ArrayList<CombinationUsage> vowelCombinations;
    private ArrayList<CombinationUsage> nonVowelCombinations;

    private ArrayList<LengthUsage> vowelLengths;
    private ArrayList<LengthUsage> nonVowelLengths;

    private ArrayList<LengthUsage> combinationCount;

    private Meta meta;

    /**
     * Initializes the Lists
     */
    public StyleBuilder(){
        lengths = new ArrayList<>();
        letters = new ArrayList<>();
        pairs = new ArrayList<>();
        beginnings = new ArrayList<>();
        ends = new ArrayList<>();
        vowelLengths = new ArrayList<>();
        vowelCombinations = new ArrayList<>();
        nonVowelLengths = new ArrayList<>();
        nonVowelCombinations = new ArrayList<>();
        combinationCount = new ArrayList<>();
    }

    /**
     * Increases the usage of that word length by one
     * @param length word length
     */
    public void pushLength(int length){
        for (LengthUsage lengthUsage : lengths) {
            if (lengthUsage.getLength() == length){
                lengthUsage.pushUsage();
                return;
            }
        }

        LengthUsage usage = new LengthUsage(length);
        usage.pushUsage();
        lengths.add(usage);
    }

    /**
     * Increases the usage of this total count of combinations in a word by one
     * @param count count of combinations in a word
     */
    public void pushCombinationCount(int count){
        for (LengthUsage lengthUsage : combinationCount) {
            if (lengthUsage.getLength() == count){
                lengthUsage.pushUsage();
                return;
            }
        }

        LengthUsage usage = new LengthUsage(count);
        usage.pushUsage();
        combinationCount.add(usage);
    }

    /**
     * Increases the usage of that letter by one
     * @param letter used letter
     */
    public void pushLetter(char letter){
        for (CharacterUsage characterUsage : letters) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        letters.add(usage);
    }

    /**
     * Increases the usage of that beginning of a word by one
     * @param letter starting letter of a word
     */
    public void pushBeginning(char letter){
        for (CharacterUsage characterUsage : beginnings) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        beginnings.add(usage);
    }

    /**
     * Increases the usage of that ending letter by one
     * @param letter ending letter of the word
     */
    public void pushEnd(char letter){
        for (CharacterUsage characterUsage : ends) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        ends.add(usage);
    }

    /**
     * Increases the usage of a pair occurring in a word by one
     * @param first first character of that pair
     * @param second second character of that pair
     */
    public void pushPair(char first, char second){
        for (PairUsage pair : pairs) {
            if (pair.getFirst() == first && pair.getSecond() == second){
                pair.pushUsage();
                return;
            }
        }

        PairUsage usage = new PairUsage(first, second);
        usage.pushUsage();
        pairs.add(usage);
    }

    /**
     * Increases the usage of that vowel combination by one
     * @param combination combination of vowels
     */
    public void pushVowelCombination(String combination){
        for (CombinationUsage combo : vowelCombinations) {
            if (combo.getCombination().equals(combination)) {
                combo.pushUsage();
                pushVowelLength(combination.length());
                return;
            }
        }

        CombinationUsage usage = new CombinationUsage(combination);
        usage.pushUsage();
        pushVowelLength(combination.length());
        vowelCombinations.add(usage);
    }

    /**
     * Increases the usage of that non vowel combination by one
     * @param combination combination of non vowels
     */
    public void pushNonVowelCombination(String combination){
        for (CombinationUsage combo : nonVowelCombinations) {
            if (combo.getCombination().equals(combination)) {
                combo.pushUsage();
                pushNonVowelLength(combination.length());
                return;
            }
        }

        CombinationUsage usage = new CombinationUsage(combination);
        usage.pushUsage();
        pushNonVowelLength(combination.length());
        nonVowelCombinations.add(usage);
    }

    /**
     * Increases the usage of one combination by one
     * @param combination combination of vowels or non vowels
     * @param vowel whether the combination is a vowel
     */
    public void pushCombination(String combination, boolean vowel){
        if (vowel) pushVowelCombination(combination);
        else pushNonVowelCombination(combination);
    }

    /**
     * Increases the usage of the length of a vowel combination
     * @param length length of vowel combination
     */
    public void pushVowelLength(int length){
        for (LengthUsage lengthUsage : vowelLengths) {
            if (lengthUsage.getLength() == length){
                lengthUsage.pushUsage();
                return;
            }
        }

        LengthUsage usage = new LengthUsage(length);
        usage.pushUsage();
        vowelLengths.add(usage);
    }

    /**
     * Increases the usage of the length of a non vowel combination
     * @param length length of non vowel combination
     */
    public void pushNonVowelLength(int length){
        for (LengthUsage lengthUsage : nonVowelLengths) {
            if (lengthUsage.getLength() == length){
                lengthUsage.pushUsage();
                return;
            }
        }

        LengthUsage usage = new LengthUsage(length);
        usage.pushUsage();
        nonVowelLengths.add(usage);
    }

    /**
     * Sets the meta
     * @param meta meta about the style
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * Builds it to a Style
     * @return fresh Style
     */
    public Style build(){
        Style style = new Style();
        style.setLengths(lengths.toArray(new LengthUsage[0]));
        style.setPairs(pairs.toArray(new PairUsage[0]));
        style.setLetters(letters.toArray(new CharacterUsage[0]));

        style.setBeginnings(beginnings.toArray(new CharacterUsage[0]));
        style.setEnds(ends.toArray(new CharacterUsage[0]));

        style.setVowelCombinations(vowelCombinations.toArray(new CombinationUsage[0]));
        style.setNonVowelCombinations(nonVowelCombinations.toArray(new CombinationUsage[0]));
        style.setVowelLengths(vowelLengths.toArray(new LengthUsage[0]));
        style.setNonVowelLengths(nonVowelLengths.toArray(new LengthUsage[0]));
        style.setCombinationCount(combinationCount.toArray(new LengthUsage[0]));

        style.setMeta(meta);
        return style;
    }
}
