package code.learning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

/**
 * @author VirtCode
 * @version 1.0
 */
public class StyleLoader {


    /**
     * Saves a StyleData to a File
     * @param data Data to save
     * @param file Path to File to save the data in
     */
    public void saveStyle(StyleData data, String file){
        try {
            FileWriter writer = new FileWriter(new File(file));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("//Vowel Usage: \n");
            Entry<Character, Integer>[] vowelUsage = data.getVowelUses();
            for (Entry<Character, Integer> entry:vowelUsage) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Consonant Usage: \n");
            Entry<Character, Integer>[] consonantUsage = data.getCononantUses();
            for (Entry<Character, Integer> entry:consonantUsage) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Vowel Combinations: \n");
            Entry<String, Integer>[] vowelCombinations = data.getVowelCombinations();
            for (Entry<String, Integer> entry:vowelCombinations) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Consonant Combinations: \n");
            Entry<String, Integer>[] consonantCombinations = data.getConsonantCombinations();
            for (Entry<String, Integer> entry:consonantCombinations) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Character Pairs: \n");
            Entry<String, Integer>[] pairs = data.getPairs();
            for (Entry<String, Integer> entry:pairs) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
