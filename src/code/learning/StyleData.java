package code.learning;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleData {

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

    /**
     * Initialize HashMaps
     */
    public StyleData(){
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

}
