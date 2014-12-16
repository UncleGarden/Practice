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
public class QueryBoard {

    public static int[][] matrix = new int[256][256];

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

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        try {
            while ((line = in.readLine()) != null) {

                String[] array = line.split("\\s+");

                if (array[0].equalsIgnoreCase("SetCol")) {
                    //System.out.println(array[0]);
                    changeCol(Integer.valueOf(array[1]), Integer.valueOf(array[2]));
                } else if (array[0].equalsIgnoreCase("SetRow")) {
                    //System.out.println(array[0]);
                    changeRow(Integer.valueOf(array[1]), Integer.valueOf(array[2]));
                } else if (array[0].equalsIgnoreCase("QueryCol")) {
                    //System.out.println(array[0]);
                    System.out.println(sumCol(Integer.valueOf(array[1])));
                } else if (array[0].equalsIgnoreCase("QueryRow")) {
                    //System.out.println(array[0]);
                    System.out.println(sumRow(Integer.valueOf(array[1])));
                }

            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }

    }

    public static void changeCol(int i, int x) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[k][i] = x;
        }
    }

    public static void changeRow(int i, int x) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = x;
        }
    }

    public static int sumCol(int i) {
        int result = 0;
        for (int k = 0; k < matrix[0].length; k++) {
            result += matrix[k][i];
        }
        return result;
    }

    public static int sumRow(int j) {
        int result = 0;
        for (int k = 0; k < matrix[0].length; k++) {
            result += matrix[j][k];
        }
        return result;
    }
}
