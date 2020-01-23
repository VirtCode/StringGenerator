package ch.virt.stringgenerator.algorithms;

/**
 * An Algorithm to to Generate Strings by switching between Vowels and Consonants
 * @author VirtCode
 * @version 1.0
 */
public class SwitchAlgorithm extends GenerationAlgorithm {
    /**
     * Generates a String with that Algorithm
     * @return Generated String
     */
    @Override
    protected String generate() {
        if (length == 0) length = randInt(8);
        String s = "";
        int vowel = randInt(2);
        for (int i = 0; i < length; i++) {
            if (vowel == 0){
                s += randomVowels();
                vowel = 1;
            }else {
                s += randomConsonants();
                vowel = 0;
            }
        }
        return s;
    }
}
