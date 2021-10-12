package ch.virt.stringgenerator.style.data;

/**
 * This class stores the usage of a single character
 * @author VirtCode
 * @version 1.0
 */
public class CharacterUsage extends Usage {

    private char character;

    /**
     * Creates a character storage
     * @param character character the usage is stored from
     */
    public CharacterUsage(char character) {
        this.character = character;
    }

    /**
     * Constructor for deserialization
     */
    public CharacterUsage() { }

    /**
     * Sets the character
     * @param character character to set
     */
    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * Returns the character
     * @return character
     */
    public char getCharacter() {
        return character;
    }
}
