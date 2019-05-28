package code.learning;

import java.io.*;
import java.util.Map.Entry;

/**
 * Class for reading and saving StyleData
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
            bufferedWriter.write("#VU\n");
            Entry<Character, Integer>[] vowelUsage = data.getVowelUses();
            for (Entry<Character, Integer> entry:vowelUsage) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Consonant Usage: \n");
            bufferedWriter.write("#CU\n");
            Entry<Character, Integer>[] consonantUsage = data.getCononantUses();
            for (Entry<Character, Integer> entry:consonantUsage) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Vowel Combinations: \n");
            bufferedWriter.write("#VC\n");
            Entry<String, Integer>[] vowelCombinations = data.getVowelCombinations();
            for (Entry<String, Integer> entry:vowelCombinations) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Consonant Combinations: \n");
            bufferedWriter.write("#CC\n");
            Entry<String, Integer>[] consonantCombinations = data.getConsonantCombinations();
            for (Entry<String, Integer> entry:consonantCombinations) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Character Pairs: \n");
            bufferedWriter.write("#CP\n");
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

    /**
     * Loads Style Data from a File
     * @param path String of the path of the file
     * @return StyleData from file
     */
    public StyleData loadStyle(String path){
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(reader);

            String current = "";
            StyleData style = new StyleData();

            String line = bufferedReader.readLine();
            while(line != null && !line.equals("")){
                if (line.startsWith("//")){

                    if (line.startsWith("#")){
                        current = line.substring(1);
                    }else {
                        String[] args = line.split(";");
                        switch (current){
                            case "VU":
                                style.forceVowelUses(args[0].charAt(0), Integer.parseInt(args[1]));
                                break;
                            case "CU":
                                style.forceConsonantUses(args[0].charAt(0), Integer.parseInt(args[1]));
                                break;
                            case "VC":
                                style.forceVowelCombination(args[0], Integer.parseInt(args[1]));
                                break;
                            case "CC":
                                style.forceConsonantCombination(args[0], Integer.parseInt(args[1]));
                                break;
                            case "CP":
                                style.forcePair(args[0], Integer.parseInt(args[1]));
                                break;
                        }
                    }

                }
                line = bufferedReader.readLine();
            }

            return style;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StyleData();
    }

}
