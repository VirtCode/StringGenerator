package code;

import code.learning.StyleLearner;
import code.learning.StyleLoader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Analyzing Data");
        StyleLearner learner = new StyleLearner();
        learner.learnFromFile("D:/Test/LoremIpsum.txt");
        System.out.println("Saving Data");
        StyleLoader loader = new StyleLoader();
        loader.saveStyle(learner.getStyle(), "D:/Test/LoremIpsum.csv");
        System.out.println("Finished!");
    }
}
