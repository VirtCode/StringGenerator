package ch.virt.stringgenerator.style;

import ch.virt.stringgenerator.style.data.LengthUsage;
import ch.virt.stringgenerator.style.data.CharacterUsage;
import ch.virt.stringgenerator.style.data.PairUsage;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Style {

    CharacterUsage[] letters;
    CharacterUsage[] beginnings;
    CharacterUsage[] ends;
    PairUsage[] pairs;
    LengthUsage[] lengths;

    public void setLetters(CharacterUsage[] letters) {
        this.letters = letters;
    }

    public void setPairs(PairUsage[] pairs) {
        this.pairs = pairs;
    }

    public void setLengths(LengthUsage[] lengths) {
        this.lengths = lengths;
    }

    public CharacterUsage[] getBeginnings() {
        return beginnings;
    }

    public void setBeginnings(CharacterUsage[] beginnings) {
        this.beginnings = beginnings;
    }

    public CharacterUsage[] getEnds() {
        return ends;
    }

    public void setEnds(CharacterUsage[] ends) {
        this.ends = ends;
    }

    public CharacterUsage[] getLetters() {
        return letters;
    }

    public PairUsage[] getPairs() {
        return pairs;
    }

    public LengthUsage[] getLengths() {
        return lengths;
    }
}
