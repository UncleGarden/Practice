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
public class Minesweeper {

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

                String[] array = line.split(";");
                String str = array[1];

                String[] lens = array[0].split(",");
                int row = Integer.valueOf(lens[0]);
                int col = Integer.valueOf(lens[1]);

                int[][] matrix = new int[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                }

                for (int k = 0; k < str.length(); k++) {
                    if (str.substring(k, k + 1).equals("*")) {

                        int temp = k;
                        int tempRow = 0;
                        int tempCol = 0;
                        if (temp >= col) {
                            while (temp >= col) {
                                temp = temp - col;
                                tempCol = temp;
                                tempRow++;
                            }
                        } else {
                            tempCol = k;
                        }
//                        System.out.println(k);
//                        System.out.println(tempRow);
//                        System.out.println(tempCol);

                        //left top
                        if (tempRow > 0 && tempCol > 0) {
                            matrix[tempRow - 1][tempCol - 1]++;

                        }
                        //top
                        if (tempRow > 0) {
                            matrix[tempRow - 1][tempCol]++;
                        }
                        //right top
                        if (tempRow > 0 && tempCol < (col - 1)) {
                            matrix[tempRow - 1][tempCol + 1]++;
                        }
                        //right
                        if (tempCol < (col - 1)) {
                            matrix[tempRow][tempCol + 1]++;
                        }
                        //right bot
                        if (tempRow < (row - 1) && tempCol < (col - 1)) {
                            matrix[tempRow + 1][tempCol + 1]++;
                        }
                        //bot
                        if (tempRow < (row - 1)) {
                            matrix[tempRow + 1][tempCol]++;
                        }
                        //left bot
                        if (tempRow < (row - 1) && tempCol > 0) {
                            matrix[tempRow + 1][tempCol - 1]++;
                        }
                        //left
                        if (tempCol > 0) {
                            matrix[tempRow][tempCol - 1]++;
                        }
                    }
                }

                int index = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {

                        if (str.substring(index, index + 1).equals("*")) {
                            System.out.print("*");
                        } else {
                            System.out.print(matrix[i][j]);
                        }
                        index++;
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
