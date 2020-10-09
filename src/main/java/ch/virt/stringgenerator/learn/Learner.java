package ch.virt.stringgenerator.learn;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.StyleBuilder;
import ch.virt.stringgenerator.style.data.Meta;

/**
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

    public Learner(String name, String description, String source) {
        this();
        this.name = name;
        this.description = description;
        this.source = source;
    }
    public Learner(){
        builder = new StyleBuilder();
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }
    public void setVowels(char[] vowels) {
        this.vowels = vowels;
    }
    public void setWordSplitter(char wordSplitter) {
        this.wordSplitter = wordSplitter;
    }

    public void setMetaName(String name) {
        this.name = name;
    }
    public void setMetaDescription(String description) {
        this.description = description;
    }
    public void setMetaSource(String source) {
        this.source = source;
    }

    private String getNonLetterReplaceRegex(){
        return "[^" + new String(letters) + "]";
    }
    private boolean isVowel(char c){
        for (char vowel : vowels) {
            if (vowel == c) return true;
        }
        return false;
    }

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

    public Style get(){
        createMeta();
        return builder.build();
    }
}
