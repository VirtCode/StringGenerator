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
    private char[] nonLetters = new char[]{'\n', '\r', '-', '.', ',', '!', '?', ':', ';', '_', '(', ')'};

    public Learner(){
        builder = new StyleBuilder();
    }

    public void setNonLetters(char[] nonLetters) {
        this.nonLetters = nonLetters;
    }

    public void setWordSplitter(char wordSplitter) {
        this.wordSplitter = wordSplitter;
    }

    public void learn(String s){
        s = s.toLowerCase();

        for (char nonLetter : nonLetters) {
            s = s.replace(nonLetter, wordSplitter);
        }

        String[] words = s.split("" + wordSplitter);

        for (String word : words) {
            char last = wordSplitter;
            char[] characters = word.toCharArray();
            if (characters.length == 0) continue;

            builder.pushBeginning(characters[0]);
            builder.pushEnd(characters[characters.length - 1]);
            builder.pushLength(characters.length);

            for (char c : characters) {
                builder.pushLetter(c);
                if (last != wordSplitter){
                    builder.pushPair(last, c);
                }
                last = c;
            }
        }
    }

    public Style get(){
        return builder.build();
    }
}
