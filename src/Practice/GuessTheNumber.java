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
 * @author Jiateng
 */
public class GuessTheNumber {

    //give you the total number of range, from 0~(N-1)    
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
                String[] array = line.split("\\s+");
                int start = 0;
                int end = Integer.valueOf(array[0]);
                int value = 0;

                for (int i = 1; i < array.length; i++) {
                    if (array[i].equals("Yay!")) {
                        if (((start + end) % 2) == 0) {
                            value = (start + end) / 2;
                        } else {
                            value = (start + end) / 2 + 1;
                        }
                        
                        System.out.println(value);
                    }
                    if (array[i].equals("Higher")) {
                        if (((start + end) % 2) == 0) {
                            value = (start + end) / 2;
                        } else {
                            value = (start + end) / 2 + 1;
                        }

                        start = value + 1;
                        //System.out.println(start);
                    }
                    if (array[i].equals("Lower")) {
                        if (((start + end) % 2) == 0) {
                            value = (start + end) / 2;
                        } else {
                            value = (start + end) / 2 + 1;
                        }

                        end = value - 1;
                        //System.out.println(end);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
