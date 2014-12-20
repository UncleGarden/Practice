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
public class SplitTheNumber {

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
        int count = 0;

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split("\\s+");
                //System.out.println(array[0]);
                String[] s = null;

                for (int i = 0; i < array[1].length(); i++) {
                    if (array[1].substring(i, i + 1).equals("-")) {
                        s = array[1].split("-");
                        //System.out.println(s[0]);
                        break;
                    } else if (array[1].substring(i, i + 1).equals("+")) {
                        s = array[1].split("\\+");
                        //System.out.println(s[0]);
                        count = 1;
                        break;
                    }
                }

                if (count == 1) {
                    System.out.println(Integer.valueOf(array[0].substring(0, s[0].length())) + Integer.valueOf(array[0].substring(s[0].length())));
                } else {
                    System.out.println(Integer.valueOf(array[0].substring(0, s[0].length())) - Integer.valueOf(array[0].substring(s[0].length())));
                }
                count = 0;
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
