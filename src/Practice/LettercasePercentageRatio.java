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
import java.text.DecimalFormat;

/**
 *
 * @author Garden
 */
public class LettercasePercentageRatio {

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

        try {
            while ((line = in.readLine()) != null) {

                char[] array = line.toCharArray();

                int count = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] <= 122 && array[i] >= 97) {
                        count++;
                    }
                }

                DecimalFormat df = new DecimalFormat("0.00");
                double l = ((double) count / (double) array.length) * 100;
                double u = 100 - l;

                System.out.print("lowercase: " + df.format(l) + " ");
                System.out.print("uppercase: " + df.format(u));
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
