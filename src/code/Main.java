package code;

import code.generation.PairAlgorithm;
import code.learning.StyleData;
import code.learning.StyleLearner;
import code.learning.StyleLoader;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*
        System.out.println("Analyzing Data");
        StyleLearner learner = new StyleLearner();
        learner.learnFromFile("D:/Test/LoremIpsum.txt");
        System.out.println("Saving Data");
        loader.saveStyle(learner.getStyle(), "D:/Test/ipsum.csv");

        */
        StyleLoader loader = new StyleLoader();
        StyleData styleData = loader.loadStyle("D:/Test/english.csv");
        System.out.println("Generating");
        PairAlgorithm algorithm = new PairAlgorithm();
        System.out.println(algorithm.generate(styleData, 8, ' '));

    }
}
