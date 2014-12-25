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
public class SwapElements {

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

                String[] array = line.split(" : ");

                String[] list = array[0].split("\\s+");

                String[] rule = array[1].split(", ");

                for (int i = 0; i < rule.length; i++) {
                    swap(list, rule[i]);
                }

                for (int j = 0; j < list.length; j++) {
                    if (j != list.length - 1) {
                        System.out.print(list[j] + " ");
                    } else {
                        System.out.print(list[j]);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void swap(String[] list, String rule) {

        String[] numbers = rule.split("-");

        String temp = "";
        temp = list[Integer.valueOf(numbers[0])];
        list[Integer.valueOf(numbers[0])] = list[Integer.valueOf(numbers[1])];
        list[Integer.valueOf(numbers[1])] = temp;
    }
}
