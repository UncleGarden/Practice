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
public class HexToDecimal {

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
                int[] list = new int[array.length];

                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 'a') {
                        list[i] = 10;
                    } else if (array[i] == 'b') {
                        list[i] = 11;
                    } else if (array[i] == 'c') {
                        list[i] = 12;
                    } else if (array[i] == 'd') {
                        list[i] = 13;
                    } else if (array[i] == 'e') {
                        list[i] = 14;
                    } else if (array[i] == 'f') {
                        list[i] = 15;
                    } else {
                        list[i] = Integer.valueOf(Character.toString(array[i]));
                    }
                }

                int result = 0;
                int count = 0;
                for (int i = 0; i < list.length; i++) {
                    result = result + list[list.length - 1 - i] * (int) Math.pow(16, count);
                    count++;
                }

                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
