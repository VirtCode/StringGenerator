package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.*;

import java.util.ArrayList;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleBuilder {

    ArrayList<LengthUsage> lengths;
    ArrayList<CharacterUsage> letters;
    ArrayList<PairUsage> pairs;

    ArrayList<CharacterUsage> beginnings;
    ArrayList<CharacterUsage> ends;

    ArrayList<CombinationUsage> vowelCombinations;
    ArrayList<CombinationUsage> nonVowelCombinations;

    ArrayList<LengthUsage> vowelLengths;
    ArrayList<LengthUsage> nonVowelLengths;

    ArrayList<LengthUsage> combinationCount;

    Meta meta;

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

    public void pushCombination(String combination, boolean vowel){
        if (vowel) pushVowelCombination(combination);
        else pushNonVowelCombination(combination);
    }

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

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

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
