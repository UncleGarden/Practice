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
public class AgeDistribution {

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
                if (line.isEmpty()) {
                    continue;
                }

                int age = Integer.valueOf(line);

                if (0 <= age && age <= 2) {
                    System.out.println("Still in Mama's arms");
                } else if (3 <= age && age <= 4) {
                    System.out.println("Preschool Maniac");
                } else if (5 <= age && age <= 11) {
                    System.out.println("Elementary school");
                } else if (12 <= age && age <= 14) {
                    System.out.println("Middle school");
                } else if (15 <= age && age <= 18) {
                    System.out.println("High school");
                } else if (19 <= age && age <= 22) {
                    System.out.println("College");
                } else if (23 <= age && age <= 65) {
                    System.out.println("Working for the man");
                } else if (66 <= age && age <= 100) {
                    System.out.println("The Golden Years");
                } else if (age < 0 || age > 100) {
                    System.out.println("This program is for humans");
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
