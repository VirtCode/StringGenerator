package ch.virt.stringgenerator;

import java.io.*;

/**
 * @author VirtCode
 * @version 1.0
 * Learns Style from Files or Strings
 */
public class Learner {
    private char[] currentNonLetters;
    private char[] currentConsonants;
    private char[] currentVowels;

    private Style style;

    /**
     * Constructor with Preset arguments
     * @see Instances
     */
    public Learner(){
        this(Instances.nonLetters, Instances.vowels, Instances.consonants, new Style());
    }

    /**
     * Advanced Constructor
     * @param nonLetters Defines which Characters are going to be ignored
     * @param consonants Defines which Letters are consonants
     * @param vowels Defines which Letters are vowels
     * @param data Previous obtained data (If not available just a StyleData Constructor)
     */
    public Learner(char[] nonLetters, char[] vowels, char[] consonants, Style data){
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
            Instances.LetterType lastType = Instances.LetterType.OTHER;
            String streak = "";

            for (int j = 0; j < chars.length; j++) {

                if (last != ' ') style.newPair(last, chars[j]);
                last = chars[j];

                Instances.LetterType currentType = whichLetterType(chars[j]);

                if (currentType != lastType){
                    if (streak.length() > 1) {
                        style.newCombo(lastType);
                        switch (lastType) {
                            case VOWEL:
                                style.newVowelCombination(streak);
                                break;
                            case CONSONANT:
                                style.newConsonantCombination(streak);
                                break;
                        }
                    }else{
                        style.newSingle(lastType);
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
     * @see Instances.LetterType
     */
    public Instances.LetterType whichLetterType(char c){
        for (char d : currentVowels) {
            if (d == c) return Instances.LetterType.VOWEL;
        }
        for (char d : currentConsonants){
            if (d == c) return Instances.LetterType.CONSONANT;
        }
        return Instances.LetterType.OTHER;
    }

    /**
     * Reads a File from Storage into an String
     * File should be in normal Text encoding
     * @param path Path of the File
     * @return Whole file in one String
     */
    public String readFile(String path){
        StringBuilder s = new StringBuilder();
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while(line != null){
                s.append("\n");
                s.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s.toString();
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
    public Style getStyle(){
        return style;
    }
}
