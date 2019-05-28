package code;

import code.learning.StyleLearner;
import code.learning.StyleLoader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Analyzing Data");
        StyleLearner learner = new StyleLearner();
        learner.learnFromFile("D:/Test/words_alpha.txt");
        System.out.println("Saving Data");
        StyleLoader loader = new StyleLoader();
        loader.saveStyle(learner.getStyle(), "D:/Test/english.csv");
        System.out.println("Finished!");
    }
}
