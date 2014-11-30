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
public class ComputerTerminal {

    public static String[][] matrix = new String[10][10];

    public static int curRow = 0;
    public static int curCol = 0;

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
        boolean control = false, insert = false, move = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = " ";
            }
        }

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                for (int i = 0; i < line.length(); i++) {
                    String cur = line.substring(i, i + 1);

                    if (!control) {
                        switch (cur) {
                            case "^":
                                control = true;
                                break;
                            default:
                                curCol = add(curRow, curCol, cur, insert);
                        }
                    } else {
                        switch (cur) {
                            case "^":
                                curCol = add(curRow, curCol, cur, insert);
                                control = false;
                                break;
                            case "c":
                                clearMatrix();
                                control = false;
                                break;
                            case "e":
                                delete(curRow, curCol);
                                control = false;
                                break;
                            case "i":
                                insert = true;
                                control = false;
                                break;
                            case "o":
                                insert = false;
                                control = false;
                                break;
                            case "h":
                                curRow = 0;
                                curCol = 0;
                                control = false;
                                break;
                            case "b":
                                curCol = 0;
                                control = false;
                                break;
                            case "d":
                                if (curRow < 9) {
                                    curRow++;
                                }
                                control = false;
                                break;
                            case "u":
                                if (curRow > 0) {
                                    curRow--;
                                }
                                control = false;
                                break;
                            case "l":
                                if (curCol > 0) {
                                    curCol--;
                                }
                                control = false;
                                break;
                            case "r":
                                if (curCol < 9) {
                                    curCol++;
                                }
                                control = false;
                                break;
                            default:
                                if (cur.charAt(0) < 48 || cur.charAt(0) > 57) {
                                    break;
                                }
                                if (!move) {
                                    move = true;
                                    curRow = cur.charAt(0) - 48;
                                } else {
                                    move = false;
                                    curCol = cur.charAt(0) - 48;
                                    control = false;
                                }
                        }
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void clearMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    public static void delete(int curRow, int curCol) {
        for (int i = curCol; i < matrix[0].length; i++) {
            matrix[curRow][i] = " ";
        }
    }

    public static int add(int curRow, int curCol, String cur, Boolean insert) {
        if (insert) {
            for (int i = 8; i >= curCol; i--) {
                matrix[curRow][i + 1] = matrix[curRow][i];
            }
        }
        matrix[curRow][curCol] = cur;
        if (curCol < 9) {
            curCol++;
        }
        return curCol;
    }
}
