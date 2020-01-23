package ch.virt.stringgenerator;

import java.util.Map.Entry;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Utilizer {

    Style style;

    public Utilizer(Style style){
        this.style = style;
    }

    public void updateStyle(Style newStyle){
        style = newStyle;
    }

    /**
     * Returns the whole vowel uses
     * @return whole uses
     */
    public int getWholeVowelUses(){
        Entry<Character, Integer>[] array = style.getVowelUses();
        int value = 0;

        for (Entry<Character, Integer> e:array) {
            value += e.getValue();
        }

        return value;
    }
    /**
     * Returns the whole consonant uses
     * @return whole uses
     */
    public int getWholeConsonantUses(){
        Entry<Character, Integer>[] array = style.getConsonantUses();
        int value = 0;

        for (Entry<Character, Integer> e:array) {
            value += e.getValue();
        }

        return value;
    }
    /**
     * Returns the whole consonant combinations
     * @return whole uses
     */
    public int getWholeConsonantCombinations(){
        Entry<String, Integer>[] array = style.getConsonantCombinations();
        int value = 0;

        for (Entry<String, Integer> e:array) {
            value += e.getValue();
        }

        return value;
    }
    /**
     * Returns the whole vowel combinations
     * @return whole uses
     */
    public int getWholeVowelCombination(){
        Entry<String, Integer>[] array = style.getVowelCombinations();
        int value = 0;

        for (Entry<String, Integer> e:array) {
            value += e.getValue();
        }

        return value;
    }

    /**
     * Returns the whole value of combination uses
     * @param c Begin letter
     * @return amount
     */
    public int getPairsFor(char c){
        Entry<String, Integer>[] array = style.getPairs();
        int value = 0;

        for (Entry<String, Integer> e:array) {
            if (e.getKey().startsWith("" + c)) value += e.getValue();
        }
        return value;
    }

    /**
     * Returns the whole amount of consonant singles and pairs
     * @return The amount of uses
     */
    public int getWholeConsonantLength(){
        return style.getCombo(Instances.LetterType.CONSONANT) + style.getSingle(Instances.LetterType.CONSONANT);
    }
    /**
     * Returns the whole amount of vowel singles and pairs
     * @return The amount of uses
     */
    public int getWholeVowelLength(){
        return style.getCombo(Instances.LetterType.VOWEL) + style.getSingle(Instances.LetterType.VOWEL);
    }

    /**
     * Returns if it is a Consonant combo at a certain Position
     * @param i Position
     * @return True if it is a Combo
     */
    public boolean isConsonantComboAt(int i){
        return i >= style.getSingle(Instances.LetterType.CONSONANT);
    }
    /**
     * Returns if it is a Vowel combo at a certain Position
     * @param i Position
     * @return True if it is a Combo
     */
    public boolean isVowelComboAt(int i){
        return i >= style.getSingle(Instances.LetterType.VOWEL);
    }

    /**
     * Returns the vowel at a certain position
     * @param i position
     * @return char at that position
     */
    public char getVowelAt(int i){
        Entry<Character, Integer>[] array = style.getVowelUses();
        int value = 0;
        int last = 0;

        for (Entry<Character, Integer> e:array) {
            value += e.getValue();
            if (i >= last && i < value) return e.getKey();
            last = value;
        }

        return ' ';
    }
    /**
     * Returns the consonant at a certain position
     * @param i position
     * @return char at that position
     */
    public char getConsonantAt(int i){
        Entry<Character, Integer>[] array = style.getConsonantUses();
        int value = 0;
        int last = 0;

        for (Entry<Character, Integer> e:array) {
            value += e.getValue();
            if (i >= last && i < value) return e.getKey();
            last = value;
        }

        return ' ';
    }
    /**
     * Returns the vowel combination at a certain position
     * @param i position
     * @return combination at that position
     */
    public String getVowelCombinationAt(int i){
        Entry<String, Integer>[] array = style.getVowelCombinations();
        int value = 0;
        int last = 0;

        for (Entry<String, Integer> e:array) {
            value += e.getValue();
            if (i >= last && i < value) return e.getKey();
            last = value;
        }

        return "";
    }
    /**
     * Returns the consonant combination at a certain position
     * @param i position
     * @return combination at that position
     */
    public String getConsonantCombinationAt(int i){
        Entry<String, Integer>[] array = style.getConsonantCombinations();
        int value = 0;
        int last = 0;

        for (Entry<String, Integer> e:array) {
            value += e.getValue();
            if (i >= last && i < value) return e.getKey();
            last = value;
        }

        return "";
    }

    /**
     * Returns the second letter of a pair at a certain position starting with a certain character
     * @param c character to start with
     * @param i position of pair
     * @return second character
     */
    public char getSecondForAt(char c, int i){
        Entry<String, Integer>[] array = style.getPairs();
        int value = 0;
        int last = 0;

        for (Entry<String, Integer> e:array) {
            if (e.getKey().startsWith("" + c)) {
                value += e.getValue();
                if (i >= last && i < value) return e.getKey().charAt(1);
                last = value;
            }
        }
        return ' ';
    }


}
