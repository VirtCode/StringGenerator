package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.LengthUsage;
import ch.virt.stringgenerator.style.data.CharacterUsage;
import ch.virt.stringgenerator.style.data.PairUsage;

import java.util.ArrayList;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleBuilder {

    ArrayList<LengthUsage> lengths;
    ArrayList<CharacterUsage> letters;
    ArrayList<PairUsage> pairs;

    ArrayList<CharacterUsage> beginnings;
    ArrayList<CharacterUsage> ends;

    public StyleBuilder(){
        lengths = new ArrayList<>();
        letters = new ArrayList<>();
        pairs = new ArrayList<>();
        beginnings = new ArrayList<>();
        ends = new ArrayList<>();
    }

    public void pushLength(int length){
        for (LengthUsage lengthUsage : lengths) {
            if (lengthUsage.getLength() == length){
                lengthUsage.pushUsage();
                return;
            }
        }

        LengthUsage usage = new LengthUsage(length);
        usage.pushUsage();
        lengths.add(usage);
    }

    public void pushLetter(char letter){
        for (CharacterUsage characterUsage : letters) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        letters.add(usage);
    }

    public void pushBeginning(char letter){
        for (CharacterUsage characterUsage : beginnings) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        beginnings.add(usage);
    }

    public void pushEnd(char letter){
        for (CharacterUsage characterUsage : ends) {
            if (characterUsage.getCharacter() == letter){
                characterUsage.pushUsage();
                return;
            }
        }

        CharacterUsage usage = new CharacterUsage(letter);
        usage.pushUsage();
        ends.add(usage);
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
        style.setLengths(lengths.toArray(new LengthUsage[0]));
        style.setPairs(pairs.toArray(new PairUsage[0]));
        style.setLetters(letters.toArray(new CharacterUsage[0]));
        style.setBeginnings(beginnings.toArray(new CharacterUsage[0]));
        style.setEnds(ends.toArray(new CharacterUsage[0]));
        return style;
    }
}
