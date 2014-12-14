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
public class Pangrams {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file input.");
        }
        String line;

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                //ASCII lowercase from 97 - 122
                String str = line.replaceAll(" ", "").toLowerCase();

                boolean[] mis = new boolean[26];
                for (int i = 0; i < mis.length; i++) {
                    mis[i] = true;
                }

                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) >= 97 && str.charAt(j) <= 122) {
                        if (mis[str.charAt(j) - 97] == true) {

                            mis[str.charAt(j) - 97] = false;
                        }
                    }
                }

                boolean flag = false;

                for (int k = 0; k < mis.length; k++) {
                    if (mis[k] == true) {
                        System.out.print((char) (k + 97));
                        flag = true;
                    }
                }

                if (!flag) {
                    System.out.print("NONE");
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
