package ch.virt.stringgenerator.style.data;

/**
 * @author VirtCode
 * @version 1.0
 */
public class Meta {
    private String name;
    private String source;
    private String wordCount;
    private char[] letters;
    private char[] vowels;
    private char[] splitter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public char[] getSplitter() {
        return splitter;
    }

    public void setSplitter(char[] splitter) {
        this.splitter = splitter;
    }

    public char[] getVowels() {
        return vowels;
    }

    public void setVowels(char[] vowels) {
        this.vowels = vowels;
    }
}
