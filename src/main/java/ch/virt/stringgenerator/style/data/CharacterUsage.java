package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class CharacterUsage {
    private char character;
    private int usage;

    public CharacterUsage(char character) {
        this.character = character;
    }

    public CharacterUsage(){}

    public char getCharacter() {
        return character;
    }

    public int getUsage() {
        return usage;
    }

    public void pushUsage(){
        usage++;
    }
}
