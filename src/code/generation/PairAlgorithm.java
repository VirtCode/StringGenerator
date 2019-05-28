package code.generation;

/**
 * @author VirtCode
 * @version 1.0
 */
public class PairAlgorithm extends GenerationAlgorithm {

    @Override
    protected String generate() {
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
