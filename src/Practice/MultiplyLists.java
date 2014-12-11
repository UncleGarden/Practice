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
public class MultiplyLists {

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

                String[] array = line.split(" \\| ");

                String[] list1 = array[0].split("\\s+");
                String[] list2 = array[1].split("\\s+");

                if (list1.length != list2.length) {
                    break;
                }

                for (int i = 0; i < list1.length; i++) {
                    System.out.print(Integer.valueOf(list1[i]) * Integer.valueOf(list2[i]));
                    if (i != list1.length - 1) {
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
