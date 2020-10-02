package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.CharacterUsage;
import ch.virt.stringgenerator.style.data.LetterUsage;
import ch.virt.stringgenerator.style.data.PairUsage;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Style {
    LetterUsage[] letters;
    PairUsage[] pairs;
    CharacterUsage[] lengths;

    public void setLetters(LetterUsage[] letters) {
        this.letters = letters;
    }

    public void setPairs(PairUsage[] pairs) {
        this.pairs = pairs;
    }

    public void setLengths(CharacterUsage[] lengths) {
        this.lengths = lengths;
    }

    public LetterUsage[] getLetters() {
        return letters;
    }

    public PairUsage[] getPairs() {
        return pairs;
    }

    public CharacterUsage[] getLengths() {
        return lengths;
    }
}
