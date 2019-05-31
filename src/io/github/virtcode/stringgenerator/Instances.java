package io.github.virtcode.stringgenerator;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Instances {
    /**
     * Chars that ar in most Texts but are no Letters
     * Preset
     */
    public static final char[] nonLetters = {'\n', '\r', ',', '\'', '\"', ':', '.', ';', '(', ')', '/', '\\', '<', '>', '!', '?', '_', '-', '[', ']', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    /**
     * Theoretical Vowels
     * Preset
     */
    public static final char[] vowels = {'A', 'O', 'U', 'I', 'E'};
    /**
     * Theoretical consonants
     * Preset
     */
    public static final char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * An Enum for storing the type of a Character
     * VOWEL = Vowel
     * CONSONANT = Consonant
     * OTHER = additional Characters
     */
    public enum LetterType{
        VOWEL,
        CONSONANT,
        OTHER
    }
}
