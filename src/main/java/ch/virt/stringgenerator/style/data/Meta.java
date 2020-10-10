package ch.virt.stringgenerator.style.data;

/**
 * This class holds the metadata of a style
 * @author VirtCode
 * @version 1.0
 */
public class Meta {
    private String name;
    private String source;
    private String description;
    private int wordCount;
    private char[] letters;
    private char[] vowels;
    private char splitter;

    /**
     * Returns the name of the style
     * @return name of the style
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the style
     * @param name name of the style
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the source the style was created from
     * @return description of source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source the style was created from
     * @param source description of source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Returns the description of the style
     * @return description of the style
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the style
     * @param description description of the style
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the count of words analyzed for that style
     * @return count of words analyzed for that style
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Sets the count of words analyzed for that style
     * @param wordCount count of words analyzed for that style
     */
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * Returns the characters that were considered as letters in that style
     * @return characters considered as letters
     */
    public char[] getLetters() {
        return letters;
    }

    /**
     * Sets the characters that were considered as letters in that style
     * @param letters characters considered as letters
     */
    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    /**
     * Returns the character that was used to split the text into words
     * @return character used to split text into words
     */
    public char getSplitter() {
        return splitter;
    }

    /**
     * Sets the character that was used to split the text into words
     * @param splitter character used to split text into words
     */
    public void setSplitter(char splitter) {
        this.splitter = splitter;
    }

    /**
     * Returns the characters that were used as vowels
     * @return characters used as vowels
     */
    public char[] getVowels() {
        return vowels;
    }

    /**
     * Sets the characters that were used as vowels
     * @param vowels characters used as vowels
     */
    public void setVowels(char[] vowels) {
        this.vowels = vowels;
    }
}
