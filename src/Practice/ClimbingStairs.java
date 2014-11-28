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
public class ClimbingStairs {

    public static String result = "";

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

                int steps = Integer.valueOf(line);

                go(steps);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void go(int num) {
        if (num == 0) {
            System.out.println(0);
        }
        if (num == 1) {
            System.out.println(1);
        }

        String[] step = new String[num + 1];
        //no
        step[0] = "0";
        //only one choice
        step[1] = "1";
        //only two choices
        step[2] = "2";
        //计算可能性。  最后一步的可能性是往前走一步，或者往前走两步的可能性加上1 or 2
        for (int i = 3; i <= num; i++) {
           
            step[i] = add(step[i - 1], step[i - 2]);
            result = "";
        }

        System.out.println(step[num]);
    }

    public static String add(String str1, String str2) {

        char[] temp1;
        char[] temp2;

        if (str1.length() > str2.length()) {
            temp1 = str1.toCharArray();
            temp2 = str2.toCharArray();
        } else {
            temp1 = str2.toCharArray();
            temp2 = str1.toCharArray();
        }

        int count = 0;
        int cur = 0;
        for (int i = 0; i < temp2.length; i++) {
            cur = Integer.valueOf(String.valueOf(temp1[temp1.length - 1 - i])) + Integer.valueOf(String.valueOf(temp2[temp2.length - 1 - i])) + count;
            //System.out.println(cur);
            if (cur >= 10) {
                cur = cur % 10;
                count = 1;
            } else {
                count = 0;
            }
            result = cur + result;
        }

        for (int i = 0; i < temp1.length - temp2.length; i++) {
            cur = Integer.valueOf(String.valueOf(temp1[temp1.length - temp2.length - 1 - i])) + count;
            if (cur >= 10) {
                cur = cur % 10;
                count = 1;
            } else {
                count = 0;
            }
            result = cur + result;
        }

        if (count == 1) {
            result = 1 + result;
        }

        return result;
    }
}
