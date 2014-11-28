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
public class CompressedSequence {

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

                String[] array = line.split("\\s+");

                int index = 0;

                if (array.length == 1) {
                    System.out.print(1 + " " + array[0]);
                }

                for (int i = 1; i < array.length; i++) {

                    if (array[i - 1].equals(array[i])) {
                        index++;
                        if (i == array.length - 1) {
                            System.out.print((index + 1) + " " + array[i - 1]);
                        }
                        continue;
                    } else {
                        if (i == array.length - 1) {
                            System.out.print((index + 1) + " " + array[i - 1] + " ");
                            System.out.print((1) + " " + array[i]);
                        } else {
                            System.out.print((index + 1) + " " + array[i - 1] + " ");
                            index = 0;
                        }
                    }
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
