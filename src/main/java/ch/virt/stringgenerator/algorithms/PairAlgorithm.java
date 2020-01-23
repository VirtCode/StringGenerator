package ch.virt.stringgenerator.algorithms;


/**
 * @author VirtCode
 * @version 1.0
 */
public class PairAlgorithm extends GenerationAlgorithm {

    /**
     * Generates a Pseudorandom String due to the Algorithm Config by setting pairs after each other.
     * @return generated String
     */
    @Override
    protected String generate() {
        if (length == 0) length = randInt(16);
        if (first == ' '){
            int firstLetterType = randInt(2);
            if (firstLetterType == 0){
                first = randomVowel();
            }else {
                first = randomConsonant();
            }
        }

        StringBuilder s = new StringBuilder("" + first);
        char last = first;

        for (int i = 0; i < length - 1; i++) {
            last = randomSecond(last);
            s.append(last);
        }
        return s.toString();
    }
}
