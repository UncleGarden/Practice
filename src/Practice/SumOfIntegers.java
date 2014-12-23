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
public class SumOfIntegers {

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

                System.out.println(sum(array));
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static int sum(String[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }

        int maxSum = Integer.valueOf(array[0]);

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int sum = add(array, i, j);

                if (sum > maxSum) {
                    maxSum = sum;
                }

//                if (sum < 0) {
//                    break;
//                }
            }
        }

        return maxSum;
    }

    public static int add(String[] array, int start, int end) {

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += Integer.valueOf(array[i]);
        }

        return sum;
    }
}
