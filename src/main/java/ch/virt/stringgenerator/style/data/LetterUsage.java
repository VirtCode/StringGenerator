package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class LetterUsage {
    private char character;
    private int usage;

    public LetterUsage(char character) {
        this.character = character;
    }

    public LetterUsage(){}

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
