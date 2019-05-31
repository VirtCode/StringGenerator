package io.github.virtcode.stringgenerator;

import java.io.*;
import java.util.Map.Entry;

/**
 * Class for reading and saving StyleData
 * @author VirtCode
 * @version 1.0
 */
public class Loader {

    /**
     * Saves a StyleData to a File
     * @param data Data to save
     * @param file Path to File to save the data in
     */
    public void saveStyle(Style data, String file){
        try {
            FileWriter writer = new FileWriter(new File(file));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("//Type Uses: \n");
            bufferedWriter.write("#TU\n");
            bufferedWriter.write("VC;" + data.getCombo(Instances.LetterType.VOWEL) + "\n");
            bufferedWriter.write("CC;" + data.getCombo(Instances.LetterType.CONSONANT) + "\n");
            bufferedWriter.write("VS;" + data.getSingle(Instances.LetterType.VOWEL) + "\n");
            bufferedWriter.write("CS;" + data.getSingle(Instances.LetterType.CONSONANT) + "\n");


            bufferedWriter.write("//Vowel Usage: \n");
            bufferedWriter.write("#VU\n");
            Entry<Character, Integer>[] vowelUsage = data.getVowelUses();
            for (Entry<Character, Integer> entry:vowelUsage) {
                bufferedWriter.write("" + entry.getKey() + ";" + entry.getValue() + "\n");
            }

            bufferedWriter.write("//Consonant Usage: \n");
            bufferedWriter.write("#CU\n");
            Entry<Character, Integer>[] consonantUsage = data.getConsonantUses();
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
    public Style loadStyle(String path){
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(reader);

            String current = "";
            Style style = new Style();

            String line = bufferedReader.readLine();
            while(line != null && !line.equals("")){
                if (!line.startsWith("//")){
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
                            case "TU":
                                switch (args[0]){
                                    case "VC":
                                        style.forceCombo(Instances.LetterType.VOWEL, Integer.parseInt(args[1]));
                                        break;
                                    case "CC":
                                        style.forceCombo(Instances.LetterType.CONSONANT, Integer.parseInt(args[1]));
                                        break;
                                    case "VS":
                                        style.forceSingle(Instances.LetterType.VOWEL, Integer.parseInt(args[1]));
                                        break;
                                    case "CS":
                                        style.forceSingle(Instances.LetterType.CONSONANT, Integer.parseInt(args[1]));
                                        break;
                                }
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
        return new Style();
    }

}