package test;

import code.generation.Generator;
import code.generation.PairAlgorithm;
import code.generation.SwitchAlgorithm;
import code.learning.StyleData;
import code.learning.StyleLearner;
import code.learning.StyleLoader;

public class Main {

    public static void main(String[] args) {
        StyleLearner learner;
        StyleLoader loader;
        StyleData data;
        Generator generator;

        learner = new StyleLearner();

        //learner.learnFromFile("D:/Test/DieSchwarzeSpinne.txt");
        //data = learner.getStyle();

        loader = new StyleLoader();
        //loader.saveStyle(data, "D:/Test/DieSchwarzeSpinne.csv");
        data = loader.loadStyle("D:/Test/DieSchwarzeSpinne.csv");

        generator = new Generator(data, new SwitchAlgorithm());
        generator.setLength(4);
        String[] names = generator.generate(128);

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
