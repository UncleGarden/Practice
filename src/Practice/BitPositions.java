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
public class BitPositions {

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

                String[] array = line.split(",");

                int number = Integer.valueOf(array[0]);
                int p1 = Integer.valueOf(array[1]);
                int p2 = Integer.valueOf(array[2]);

                String binaryNum = Integer.toBinaryString(number);
                char[] positions = binaryNum.toCharArray();

                if (positions[positions.length - p1] == positions[positions.length - p2]) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
