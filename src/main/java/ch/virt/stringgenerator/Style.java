package ch.virt.stringgenerator;

import java.util.Map.Entry;
import java.util.HashMap;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Style {

    /**
     * Saves the uses of individual Vowels
     */
    private HashMap<Character, Integer> vowelUses;
    /**
     * Saves the uses of individual Consonants
     */
    private HashMap<Character, Integer> consonantUses;
    /**
     * Saves the uses of vowel Combinations
     */
    private HashMap<String, Integer> vowelCombinations;
    /**
     * Saves the uses of consonants Combinations
     */
    private HashMap<String, Integer> consonantCombinations;

    /**
     * Saves character pairs and their uses
     */
    private HashMap<String, Integer> pairs;

    private int consonantSingles;
    private int consonantCombos;

    private int vowelSingles;
    private int vowelCombos;

    /**
     * Initialize HashMaps
     */
    public Style(){
        this.vowelUses = new HashMap<>();
        this.consonantUses = new HashMap<>();
        this.vowelCombinations = new HashMap<>();
        this.consonantCombinations = new HashMap<>();
        this.pairs = new HashMap<>();

    }

    /**
     * Puts a Vowel into the Style and count it's uses
     * @param c Character to add
     */
    public void newVowel(char c){
        vowelUses.merge(c, 1, Integer::sum);
    }
    /**
     * Puts a Consonant into the Style and count it's uses
     * @param c Character to add
     */
    public void newConsonant(char c){
        consonantUses.merge(c, 1, Integer::sum);
    }
    /**
     * Puts a Consonant into the Style and count it's uses
     * @param s Combination to add
     */
    public void newVowelCombination(String s){
        vowelCombinations.merge(s, 1, Integer::sum);
    }
    /**
     * Puts a Consonant into the Style and count it's uses
     * @param s Combination to add
     */
    public void newConsonantCombination(String s){
        consonantCombinations.merge(s, 1, Integer::sum);
    }

    /**
     * Puts a new pair to the style
     * @param c1 First char of Pair
     * @param c2 Second char of Pair
     */
    public void newPair(char c1, char c2){
        pairs.merge("" + c1 + c2, 1, Integer::sum);
    }

    /**
     * Adds a new Single to the data
     * @param type Letter type
     */
    public void newSingle(Instances.LetterType type){
        switch (type) {
            case VOWEL:
                vowelSingles++;
                break;
            case CONSONANT:
                consonantSingles++;
                break;
        }
    }

    /**
     * Adds a new Single to the data
     * @param type Letter type
     */
    public void newCombo(Instances.LetterType type){
        switch (type) {
            case VOWEL:
                vowelCombos++;
                break;
            case CONSONANT:
                consonantCombos++;
                break;
        }
    }

    /**
     * Get the Vowel Uses
     * @return Entry Array with data
     */
    public Entry<Character, Integer>[] getVowelUses(){
        return vowelUses.entrySet().toArray(new Entry[0]);
    }

    /**
     * Get the Consonant Uses
     * @return Entry Array with data
     */
    public Entry<Character, Integer>[] getConsonantUses(){
        return consonantUses.entrySet().toArray(new Entry[0]);
    }

    /**
     * Get the Vowel Combinations
     * @return Entry Array with data
     */
    public Entry<String, Integer>[] getVowelCombinations(){
        return vowelCombinations.entrySet().toArray(new Entry[0]);
    }

    /**
     * Get the Consonant Combinations
     * @return Entry Array with data
     */
    public Entry<String, Integer>[] getConsonantCombinations(){
        return consonantCombinations.entrySet().toArray(new Entry[0]);
    }

    /**
     * Get all Letter Pairs
     * @return Entry Array with data
     */
    public Entry<String, Integer>[] getPairs(){
        return pairs.entrySet().toArray(new Entry[0]);
    }

    /**
     * Returns the amount of singles for a Lettertype
     * @param type Lettertype to return
     * @return Amount of singles
     */
    public int getSingle(Instances.LetterType type){
        switch (type) {
            case VOWEL: return vowelSingles;
            case CONSONANT: return consonantSingles;
        }
        return 0;
    }

    /**
     * Returns the amount of combos for a Lettertype
     * @param type Lettertype to return
     * @return Amount of combos
     */
    public int getCombo(Instances.LetterType type){
        switch (type) {
            case VOWEL: return vowelCombos;
            case CONSONANT: return consonantCombos;
        }
        return 0;
    }

    /**
     * Overwrites the Entry for Vowel Use
     * @param c char to add
     * @param i amount to add
     */
    void forceVowelUses(char c, int i){
        vowelUses.put(c, i);
    }

    /**
     * Overwrites the Entry for Consonant Use
     * @param c char to add
     * @param i amount to add
     */
    void forceConsonantUses(char c, int i){
        consonantUses.put(c, i);
    }

    /**
     * Overwrites the Entry for Vowel Combinations
     * @param s string to add
     * @param i amount to add
     */
    void forceVowelCombination(String s, int i){
        vowelCombinations.put(s, i);
    }

    /**
     * Overwrites the Entry for Consonant Combinations
     * @param s string to add
     * @param i amount to add
     */
    void forceConsonantCombination(String s, int i){
        consonantCombinations.put(s, i);
    }

    /**
     * Overwrites the Entry for Pair
     * @param s string to add
     * @param i amount to add
     */
    void forcePair(String s, int i){
        pairs.put(s, i);
    }

    /**
     * Overwrites the Singels of a Lettertype
     * @param type Lettertype to overwrite
     * @param i amount of Singles
     */
    void forceSingle(Instances.LetterType type, int i){
        switch (type) {
            case VOWEL:
                vowelSingles = i;
                break;
            case CONSONANT:
                consonantSingles = i;
                break;
        }
    }

    /**
     * Overwrites the Combos of a Lettertype
     * @param type Lettertype to overwrite
     * @param i amount of combos
     */
    void forceCombo(Instances.LetterType type, int i){
        switch (type) {
            case VOWEL:
                vowelCombos = i;
                break;
            case CONSONANT:
                consonantCombos = i;
                break;
        }
    }
}
