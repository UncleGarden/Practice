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
import java.util.ArrayList;

/**
 *
 * @author Garden
 */
public class SetIntersection {

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
        ArrayList<String> list = new ArrayList();

        try {
            while ((line = in.readLine()) != null) {

                String[] array = line.split(";");
                String str1 = array[0];
                String str2 = array[1];

                String[] numbers1 = str1.split(",");
                String[] numbers2 = str2.split(",");

                for (int i = 0; i < numbers1.length; i++) {
                    for (int j = 0; j < numbers2.length; j++) {
                        if (numbers1[i].equals(numbers2[j])) {
                            list.add(numbers1[i]);
                        }
                    }
                }

                for (int k = 0; k < list.size(); k++) {
                    System.out.print(list.get(k));
                    if (k < list.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                list.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
