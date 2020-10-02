package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.CharacterUsage;
import ch.virt.stringgenerator.style.data.LetterUsage;
import ch.virt.stringgenerator.style.data.PairUsage;

import java.util.ArrayList;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleBuilder {

    ArrayList<CharacterUsage> lengths;
    ArrayList<LetterUsage> letters;
    ArrayList<PairUsage> pairs;

    public StyleBuilder(){
        lengths = new ArrayList<>();
        letters = new ArrayList<>();
        pairs = new ArrayList<>();
    }

    public void pushLength(int length){
        for (CharacterUsage lengthUsage : lengths) {
            if (lengthUsage.getLength() == length){
                lengthUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(length);
        usage.pushUsage();
        lengths.add(usage);
    }

    public void pushLetter(char letter){
        for (LetterUsage letterUsage : letters) {
            if (letterUsage.getCharacter() == letter){
                letterUsage.pushUsage();
                return;
            }
        }

        LetterUsage usage = new LetterUsage(letter);
        usage.pushUsage();
        letters.add(usage);
    }

    public void pushPair(char first, char second){
        for (PairUsage pair : pairs) {
            if (pair.getFirst() == first && pair.getSecond() == second){
                pair.pushUsage();
                return;
            }
        }

        PairUsage usage = new PairUsage(first, second);
        usage.pushUsage();
        pairs.add(usage);
    }

    public Style build(){
        Style style = new Style();
        style.setLengths(lengths.toArray(new CharacterUsage[0]));
        style.setPairs(pairs.toArray(new PairUsage[0]));
        style.setLetters(letters.toArray(new LetterUsage[0]));
        return style;
    }
}
