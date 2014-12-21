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
import java.util.HashMap;

/**
 *
 * @author Garden
 */
public class Sudoku {

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
                int len = Integer.valueOf(array[0]);
                String[] nums = array[1].split(",");

                int[][] sodoku = new int[len][len];

                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        sodoku[i][j] = Integer.valueOf(nums[i * len + j]);
                        //System.out.print(sodoku[i][j]);
                    }
                }
                //System.out.println();
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        //System.out.print(sodoku[i][j]);
                    }
                    //System.out.println();
                }

                boolean flag = check(sodoku);

                if (flag) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static boolean check(int[][] sodoku) {
        int len = sodoku.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        //check every row
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (hm.containsValue(sodoku[i][j])) {
                    //System.out.println("row error");
                    return false;
                } else {
                    hm.put(j, sodoku[i][j]);
                }
            }
            hm.clear();
        }
        //check every column
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (hm.containsValue(sodoku[i][j])) {
                    //System.out.println("col error");
                    return false;
                } else {
                    hm.put(i, sodoku[i][j]);
                }
            }
            hm.clear();
        }
        //check every len*len
        int count = 0;
        double d = Math.sqrt(len);
        int l = (int) d;
        //System.out.println(l);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                //
                for (int m = 0; m < l; m++) {
                    for (int n = 0; n < l; n++) {
                        count++;
                        if (hm.containsValue(sodoku[i * l + m][j * l + n])) {
                            return false;
                        } else {
                            hm.put(count, sodoku[i * l + m][j * l + n]);
                        }
                    }
                }
                hm.clear();
            }
        }
        return true;
    }
}
