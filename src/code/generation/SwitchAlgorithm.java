package code.generation;

/**
 * @author VirtCode
 * @version 1.0
 */
public class SwitchAlgorithm extends GenerationAlgorithm{
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
