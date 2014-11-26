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
public class ArmstrongNumbers {

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
        int result = 0;

        try {
            while ((line = in.readLine()) != null) {

                int power = line.length();

                for (int i = 0; i < power; i++) {
                    result += Math.pow(Integer.valueOf(line.substring(i, i + 1)), power);
                }

                if (result == Integer.valueOf(line)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

                result = 0;
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
