/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Garden
 */
public class MixedContent {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Exception:" + fnfe);
        }
        String line;
        String result = "";

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(",");
                ArrayList<String> words = new ArrayList<>();
                ArrayList<String> numbers = new ArrayList<>();

                for (int i = 0; i < array.length; i++) {
                    try {
                        Integer.parseInt(array[i]);
                        numbers.add(array[i]);
                    } catch (NumberFormatException nfe) {
                        words.add(array[i]);
                    }
                }

                for (int j = 0; j < words.size(); j++) {
                    result += words.get(j);
                    if (j != words.size() - 1) {
                        result += ",";
                    }
                }

                if (words.size() > 0 && numbers.size() > 0) {
                    result += "|";
                }

                for (int k = 0; k < numbers.size(); k++) {
                    result += numbers.get(k);
                    if (k != numbers.size() - 1) {
                        result += ",";
                    }
                }

                System.out.println(result);
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
