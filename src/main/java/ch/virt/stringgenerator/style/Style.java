package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.*;

/**
 * This class holds all information about analyzed words
 * @author VirtCode
 * @version 1.0
 */
public class Style {

    private Meta meta;

    private CharacterUsage[] letters;
    private CharacterUsage[] beginnings;
    private CharacterUsage[] ends;
    private PairUsage[] pairs;
    private LengthUsage[] lengths;

    private CombinationUsage[] vowelCombinations;
    private LengthUsage[] vowelLengths;

    private CombinationUsage[] nonVowelCombinations;
    private LengthUsage[] nonVowelLengths;

    private LengthUsage[] combinationCount;

    public void setLetters(CharacterUsage[] letters) {
        this.letters = letters;
    }

    public void setPairs(PairUsage[] pairs) {
        this.pairs = pairs;
    }

    public void setLengths(LengthUsage[] lengths) {
        this.lengths = lengths;
    }

    public CharacterUsage[] getBeginnings() {
        return beginnings;
    }

    public void setBeginnings(CharacterUsage[] beginnings) {
        this.beginnings = beginnings;
    }

    public CharacterUsage[] getEnds() {
        return ends;
    }

    public void setEnds(CharacterUsage[] ends) {
        this.ends = ends;
    }

    public CharacterUsage[] getLetters() {
        return letters;
    }

    public PairUsage[] getPairs() {
        return pairs;
    }

    public LengthUsage[] getLengths() {
        return lengths;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public CombinationUsage[] getVowelCombinations() {
        return vowelCombinations;
    }

    public void setVowelCombinations(CombinationUsage[] vowelCombinations) {
        this.vowelCombinations = vowelCombinations;
    }

    public LengthUsage[] getVowelLengths() {
        return vowelLengths;
    }

    public void setVowelLengths(LengthUsage[] vowelLengths) {
        this.vowelLengths = vowelLengths;
    }

    public CombinationUsage[] getNonVowelCombinations() {
        return nonVowelCombinations;
    }

    public void setNonVowelCombinations(CombinationUsage[] nonVowelCombinations) {
        this.nonVowelCombinations = nonVowelCombinations;
    }

    public LengthUsage[] getNonVowelLengths() {
        return nonVowelLengths;
    }

    public void setNonVowelLengths(LengthUsage[] nonVowelLengths) {
        this.nonVowelLengths = nonVowelLengths;
    }

    public LengthUsage[] getCombinationCount() {
        return combinationCount;
    }

    public void setCombinationCount(LengthUsage[] combinationCount) {
        this.combinationCount = combinationCount;
    }
}
