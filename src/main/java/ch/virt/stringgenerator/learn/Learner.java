package ch.virt.stringgenerator.learn;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.StyleBuilder;
import ch.virt.stringgenerator.style.data.Meta;

/**
 * This converts a text or words into a Style
 * @author VirtCode
 * @version 1.0
 */
public class Learner {

    private StyleBuilder builder;
    private int wordCount;

    private char wordSplitter = ' ';
    private char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] vowels = "aeiou".toCharArray();

    private String name = "";
    private String description = "";
    private String source = "";

    /**
     * Creates a Learner
     * @param name name of the style to learn
     * @param description description of the style
     * @param source description of the source the words came from
     */
    public Learner(String name, String description, String source) {
        this();
        this.name = name;
        this.description = description;
        this.source = source;
    }

    /**
     * Creates a Learner
     */
    public Learner(){
        builder = new StyleBuilder();
    }

    /**
     * Sets the characters the learner uses letters
     * @param letters characters to use as letters
     */
    public void setLetters(char[] letters) {
        this.letters = letters;
    }
    /**
     * Sets the characters the learner uses a vowels
     * @param vowels characters to use as vowels
     */
    public void setVowels(char[] vowels) {
        this.vowels = vowels;
    }
    /**
     * Sets the character the learner uses to split words from each other
     * @param wordSplitter character to split words from each other
     */
    public void setWordSplitter(char wordSplitter) {
        this.wordSplitter = wordSplitter;
    }

    /**
     * Sets the name of the style the learner is creating
     * @param name name of the style
     */
    public void setMetaName(String name) {
        this.name = name;
    }
    /**
     * Sets the description of the style the learner is creating
     * @param description description of the style
     */
    public void setMetaDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the source of the style the learner is creating
     * @param source source of the style
     */
    public void setMetaSource(String source) {
        this.source = source;
    }

    /**
     * Creates a regex to replace characters that are not letters
     * @return regex to replace non letters
     */
    private String getNonLetterReplaceRegex(){
        return "[^" + new String(letters) + "]";
    }

    /**
     * Checks whether a character is a vowel
     * @param c character
     * @return is vowel
     */
    private boolean isVowel(char c){
        for (char vowel : vowels) {
            if (vowel == c) return true;
        }
        return false;
    }

    /**
     * Learns the style from a string
     * @param s string to learn from
     */
    public void learn(String s){
        s = s.toLowerCase();
        s = s.replaceAll(getNonLetterReplaceRegex(), "" + wordSplitter);

        String[] words = s.split("" + wordSplitter);
        for (String word : words) {
            if (word.length() == 0) continue;
            wordCount++;
            char[] characters = word.toCharArray();

            builder.pushBeginning(characters[0]);
            builder.pushEnd(characters[characters.length - 1]);
            builder.pushLength(characters.length);

            char last = wordSplitter;
            StringBuilder currentCombination = null;
            boolean currentVowel = false;
            int combinationCount = 0;

            for (char c : characters) {
                builder.pushLetter(c);

                if (last != wordSplitter){
                    builder.pushPair(last, c);
                }
                last = c;

                boolean vowel = isVowel(c);

                if (currentCombination == null) {
                    currentCombination = new StringBuilder();
                    currentCombination.append(c);
                    currentVowel = vowel;
                }else {
                    if (currentVowel != vowel) {
                        builder.pushCombination(currentCombination.toString(), currentVowel);
                        currentCombination = new StringBuilder();
                        currentVowel = vowel;
                        combinationCount++;
                    }

                    currentCombination.append(c);
                }
            }

            combinationCount++;
            builder.pushCombination(currentCombination.toString(), currentVowel);
            builder.pushCombinationCount(combinationCount);
        }
    }

    /**
     * Creates the meta for the style
     */
    private void createMeta(){
        Meta meta = new Meta();
        meta.setLetters(letters);
        meta.setVowels(vowels);
        meta.setSplitter(wordSplitter);
        meta.setWordCount(wordCount);
        meta.setName(name);
        meta.setDescription(description);
        meta.setSource(source);

        builder.setMeta(meta);
    }

    /**
     * Returns the finished style
     * @return finished style
     */
    public Style get(){
        createMeta();
        return builder.build();
    }
}
