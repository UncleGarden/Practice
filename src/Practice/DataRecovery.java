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
public class DataRecovery {

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

                String[] array = line.split(";");

                String[] str1 = array[0].split("\\s+");
                String[] str2 = array[1].split("\\s+");
                String[] temp = new String[str1.length];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = "0";
                }
                //create all numbers which match the string position
                String[] newStr2 = new String[str1.length];

                for (int i = 0; i < str2.length; i++) {
                    temp[Integer.valueOf(str2[i]) - 1] = "filled";
                }

                for (int j = 0; j < temp.length; j++) {
                    if (j < str2.length) {
                        newStr2[j] = str2[j];
                    }
                    if (temp[j].equals("0")) {
                        newStr2[str2.length] = String.valueOf(j + 1);
                    }
                }

                //put string in right place
                String[] result = new String[str1.length];

                for (int k = 0; k < result.length; k++) {
                    result[Integer.valueOf(newStr2[k]) - 1] = str1[k];
                }

                for (int l = 0; l < result.length; l++) {
                    System.out.print(result[l]);
                    if (l != result.length - 1) {
                        System.out.print(" ");
                    }
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
