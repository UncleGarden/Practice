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
import java.util.Arrays;

/**
 *
 * @author Garden
 */
public class BeautifulStrings {

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
        int amount = 0;
        int[] num = new int[26];

        try {
            while ((line = in.readLine()) != null) {

                line = line.toLowerCase();

                for (int j = 0; j < num.length; j++) {
                    num[j] = 0;
                }
                
                for (int i = 0; i < line.length(); i++) {
                    int x = (int) line.charAt(i);
                    if (x <= 122 && x >= 97) {
                        num[x - 97]++;
                    }
                }

                Arrays.sort(num);

                int upper = 26;

                for (int k = 0; k < num.length; k++) {
                    amount += num[num.length - 1 - k] * upper;
                    upper--;
                }

                System.out.println(amount);
                amount = 0;
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
