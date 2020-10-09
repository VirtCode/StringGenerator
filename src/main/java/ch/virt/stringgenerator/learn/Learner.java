package ch.virt.stringgenerator.learn;

import ch.virt.stringgenerator.style.Style;
import ch.virt.stringgenerator.style.StyleBuilder;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Learner {

    StyleBuilder builder;

    private char wordSplitter = ' ';
    private char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] vowels = "aeiou".toCharArray();

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

    public Style get(){
        return builder.build();
    }
}
