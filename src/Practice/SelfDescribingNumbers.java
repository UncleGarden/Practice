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
import java.util.Arrays;

/**
 *
 * @author Garden
 */
public class SelfDescribingNumbers {

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

                for (int i = 0; i < list.length; i++) {
                    list[i] = Integer.valueOf(Character.toString(array[i]));
                }
                Arrays.sort(list);

                int[] result = check(list);
                Arrays.sort(result);

                if (same(list, result)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }

            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static int[] check(int[] array) {

        int[] result = new int[array.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        int position = 0;
        while (position != array.length) {

            for (int i = 0; i < array.length; i++) {
                if (position == array[i]) {
                    result[position] += 1;
                }
            }
            position++;
        }

        return result;
    }

    public static boolean same(int[] list, int[] result) {
        boolean flag = true;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != result[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
