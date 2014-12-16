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
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 *
 * @author Garden
 */
public class PrimeNumbers {

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

                int n = Integer.valueOf(line);

                //just think about less n numbers
                boolean[] matrix = new boolean[n];

                for (int i = 0; i < n; i++) {
                    matrix[i] = true;
                }

                //O(sqrt(n))
                for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                    if (matrix[i] == true) {
                        for (int j = i * i; j < n; j = j + i) {
                            matrix[j] = false;
                        }
                    }
                }

                int index = 0;
                for (int i = n - 1; i > 0; i--) {
                    if (matrix[i] == true) {
                        index = i;
                        break;
                    }
                }

                for (int i = 2; i < n; i++) {
                    if (matrix[i] == true) {
                        System.out.print(i);
                        if (i != index) {
                            System.out.print(",");
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
