package code.learning;

import java.io.*;
import code.learning.StyleInstances.LetterType;

import static code.learning.StyleInstances.LetterType.*;

/**
 * @author VirtCode
 * @version 1.0
 * Learns Style from Files or Strings
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
        this(StyleInstances.nonLetters, StyleInstances.vowels, StyleInstances.consonants, new StyleData());
    }

    /**
     * Advanced Constructor
     * @param nonLetters Defines which Characters are going to be ignored
     * @param consonants Defines which Letters are consonants
     * @param vowels Defines which Letters are vowels
     * @param data Previous obtained data (If not available just a StyleData Constructor)
     */
    public StyleLearner(char[] nonLetters, char[] vowels, char[] consonants, StyleData data){
        this.currentNonLetters = nonLetters;
        this.currentConsonants = consonants;
        this.currentVowels = vowels;
        style = data;
    }

    /**
     * Learns Style information from File
     * @param path Path of File
     */
    public void learnFromFile(String path){
        String s = readFile(path);
        if (s == null || s.equals("")) return;
        learnFromString(s);
    }

    /**
     * Learns Style information from a Sting
     * @param s Sting to learn from
     */
    public void learnFromString(String s){
        s = cleanString(s);

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();

            char last = ' ';
            LetterType lastType = OTHER;
            String streak = "";

            for (int j = 0; j < chars.length; j++) {

                if (last != ' ') style.newPair(last, chars[j]);
                last = chars[j];

                LetterType currentType = whichLetterType(chars[j]);

                if (currentType != lastType){
                    if (streak.length() > 1) {
                        switch (lastType) {
                            case VOWEL:
                                style.newVowelCombination(streak);
                                break;
                            case CONSONANT:
                                style.newConsonantCombination(streak);
                                break;
                        }
                    }
                    streak = "";
                }

                lastType = currentType;
                streak += chars[j];

                switch (currentType){
                    case VOWEL:
                        style.newVowel(chars[j]);
                        break;
                    case CONSONANT:
                        style.newConsonant(chars[j]);
                        break;
                }
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
        for (char d : currentVowels) {
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

    /**
     * Get the StyleData till now
     * @return Current StyleData
     */
    public StyleData getStyle(){
        return style;
    }
}
