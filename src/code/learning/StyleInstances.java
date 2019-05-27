package code.learning;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleInstances {
    /**
     * Chars that ar in most Texts but are no Letters
     * Preset
     */
    public static final char[] nonLetters = {'\n', '\r', ',', '\'', '\"', ':', '.', ';', '(', ')', '/', '\\', '<', '>'};
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
     * An Enum for storing the type of an Character
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
