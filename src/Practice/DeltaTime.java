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
 * You are given the pairs of time values. The values are in the HH:MM:SS format
 * with leading zeros. Your task is to find out the time difference between the
 * pairs.
 *
 * @author Jiateng
 */
public class DeltaTime {

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
                String[] array = line.split("\\s+");
                String s1 = array[0].replace(":", "");
                String s2 = array[1].replace(":", "");
                if (Integer.valueOf(s1) < Integer.valueOf(s2)) {
                    String temp = "";
                    temp = s1;
                    s1 = s2;
                    s2 = temp;
                }

                int min = 0;
                int hour = 0;
                String p1 = "";
                String p2 = "";
                String p3 = "";

                //second
                if (Integer.valueOf(s1.substring(4, 6)) >= Integer.valueOf(s2.substring(4, 6))) {
                    int t3 = Integer.valueOf(s1.substring(4, 6)) - Integer.valueOf(s2.substring(4, 6));
                    if (t3 < 10) {
                        p3 += "0";
                    }
                    p3 += String.valueOf(t3);
                } else {
                    min = 1;
                    int t3 = Integer.valueOf(s1.substring(4, 6)) + 60 - Integer.valueOf(s2.substring(4, 6));
                    if (t3 < 10) {
                        p3 += "0";
                    }
                    p3 += String.valueOf(t3);
                }
                //min
                if ((Integer.valueOf(s1.substring(2, 4)) - min) >= Integer.valueOf(s2.substring(2, 4))) {
                    int t2 = (Integer.valueOf(s1.substring(2, 4)) - min) - Integer.valueOf(s2.substring(2, 4));
                    if (t2 < 10) {
                        p2 += "0";
                    }
                    p2 += String.valueOf(t2);
                } else {
                    hour = 1;
                    int t2 = (Integer.valueOf(s1.substring(2, 4)) - min) + 60 - Integer.valueOf(s2.substring(2, 4));
                    if (t2 < 10) {
                        p2 += "0";
                    }
                    p2 += String.valueOf(t2);
                }
                //hour
                if ((Integer.valueOf(s1.substring(0, 2)) - hour) >= Integer.valueOf(s2.substring(0, 2))) {
                    int t1 = (Integer.valueOf(s1.substring(0, 2)) - hour) - Integer.valueOf(s2.substring(0, 2));
                    if (t1 < 10) {
                        p1 += "0";
                    }
                    p1 += String.valueOf(t1);
                } else {
                    hour = 1;
                    int t1 = (Integer.valueOf(s1.substring(0, 2)) - hour) + 60 - Integer.valueOf(s2.substring(0, 2));
                    if (t1 < 10) {
                        p1 += "0";
                    }
                    p1 += String.valueOf(t1);
                }
                System.out.println(p1 + ":" + p2 + ":" + p3);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
