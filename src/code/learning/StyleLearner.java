package code.learning;

import java.io.*;
import code.learning.StyleInstances.LetterType;

import static code.learning.StyleInstances.LetterType.*;


/**
 * @author VirtCode
 * @version 1.0
 * Learns Style from Files
 */
public class StyleLearner {
    private char[] currentNonLetters;
    private char[] currentConsonants;
    private char[] currentVowels;

    private StyleData style;

    /**
     * Constructor with Preset arguments
     * @see StyleInstances
     */
    public StyleLearner(){
        this(StyleInstances.nonLetters, StyleInstances.consonants, StyleInstances.vowels);
    }

    /**
     * Advanced Constructor
     * @param nonLetters Defines which Characters are going to be ignored
     * @param consonants Defines which Letters are consonants
     * @param vowels Defines which Letters are vowels
     */
    public StyleLearner(char[] nonLetters, char[] vowels, char[] consonants){
        this.currentNonLetters = nonLetters;
        this.currentConsonants = consonants;
        this.currentVowels = vowels;
        style = new StyleData();
    }

    /**
     *
     */
    public void learnFromFile(){
    }

    /**
     * Learns Style information from a Sting
     * @param s Sting to learn from
     */
    public void learnFromString(String s){
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {

            }
        }

    }

    /**
     * Get the type of a Character
     * @param c Character to specify
     * @return Type of character stored in LetterType Enum
     * @see StyleInstances.LetterType
     */
    public LetterType whichLetterType(char c){
        for (char d :currentVowels) {
            if (d == c) return VOWEL;
        }
        for (char d : currentConsonants){
            if (d == c) return CONSONANT;
        }
        return OTHER;
    }

    /**
     * Reads a File from Storage into an String
     * File should be in normal Text encoding
     * @param path Path of the File
     * @return Whole file in one String
     */
    public String readFile(String path){
        String s = "";
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while(line != null){
                s += "\n" + line;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    /**
     * Cleans and removes nonLetters from String
     * @param s Input String
     * @return Cleaned String
     */
    public String cleanString(String s){
        s = s.toUpperCase();
        for (char c:currentNonLetters) {
            s = s.replace(c, ' ');
        }
        return s.replace("  ", " ");
    }


}
