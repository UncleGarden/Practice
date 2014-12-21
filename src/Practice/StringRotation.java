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
public class StringRotation {

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
                String str1 = array[0];
                String str2 = array[1];

                if (str1.length() != str2.length()) {
                    System.out.println("False");
                }

                for (int i = 0; i < str2.length(); i++) {
                    String s1 = str1.substring(0, 1);
                    if (s1.equals(str2.substring(i, i + 1))) {
                        if (str2.substring(i, str2.length()).equals(str1.substring(0, str2.length() - i)) && str2.substring(0, i).equals(str1.substring(str2.length() - i, str1.length()))) {
//                            System.out.println(str2.substring(i, str2.length()));
//                            System.out.println(str1.substring(0, str2.length() - i));
//                            System.out.println(str2.substring(0, i));
//                            System.out.println(str1.substring(str2.length()-i, str1.length()));
                            System.out.println("True");
                            break;
                        }
                    }
                    if (i == str2.length() - 1) {
                        System.out.println("False");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
