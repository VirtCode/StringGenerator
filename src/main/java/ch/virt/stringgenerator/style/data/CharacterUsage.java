package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class CharacterUsage extends Usage{
    private char character;

    public CharacterUsage(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
