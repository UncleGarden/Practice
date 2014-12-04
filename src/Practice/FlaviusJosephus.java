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
public class FlaviusJosephus {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file input.");
        }
        String line;

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(",");

                int len = Integer.valueOf(array[0]);

                boolean[] matrix = new boolean[len];

                for (int i = 0; i < matrix.length; i++) {
                    matrix[i] = true;
                }

                int cir = Integer.valueOf(array[1]);

                int count = 0;
                int index = 0;
                int change = 0;

                while (change != matrix.length) {

                    if (index == matrix.length) {
                        index = 0;
                    }

                    if (matrix[index] == true) {
                        count++;
                    }

                    if (count % cir == 0 && matrix[index] != false) {
                        System.out.print(index);
                        if (change != matrix.length - 1) {
                            System.out.print(" ");
                        }
                        matrix[index] = false;
                        change++;
                    }

                    index++;
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
