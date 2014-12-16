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
 * You are given a text. Write a program which outputs its lines according to
 * the following rules:
 *
 * If line length is ≤ 55 characters, print it without any changes. If the line
 * length is > 55 characters, change it as follows: Trim the line to 40
 * characters. If there are spaces ‘ ’ in the resulting string, trim it once
 * again to the last space (the space should be trimmed too). Add a string ‘...
 * <Read More>’ to the end of the resulting string and print it.
 *
 * @author Jiateng
 */
public class ReadMore {

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
                //System.out.println(line);
                //System.out.println(line.length());
                int len = line.length();
                if (len <= 55) {
                    System.out.println(line);
                } else {
                    String temp = line.substring(0, 40);
                    int lastSpace = 40;
                    for (int i = temp.length()-1; i >= 0; i--) {
                        if (temp.charAt(i) == ' ') {
                            lastSpace = i;
                            break;
                        }
                    }
                    String result = temp.substring(0, lastSpace);
                    result += "... <Read More>";
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
