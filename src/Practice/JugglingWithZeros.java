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

/**
 *
 * @author Garden
 */
public class JugglingWithZeros {

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
        long amount = 0;

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split("\\s+");

                for (int i = 0; i < array.length; i += 2) {
                    if (array[i].equals("0")) {
                        result += array[i + 1];
                    } else if (array[i].equals("00")) {
                        for (int j = 0; j < array[i + 1].length(); j++) {
                            result += "1";
                        }
                    }
                }

                for (int k = result.length() - 1; k >= 0; k--) {
                    amount += Long.valueOf(result.substring(k, k + 1)) * (long) Math.pow(2, result.length() - 1 - k);
                }

                System.out.println(amount);
                result = "";
                amount = 0;
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
