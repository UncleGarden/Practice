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
import java.util.HashMap;

/**
 *
 * @author Garden
 */
public class TheMajorElement {

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
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(",");

                for (int i = 0; i < array.length; i++) {
                    if (hm.containsKey(array[i])) {
                        int temp = hm.remove(array[i]);
                        hm.put(array[i], temp + 1);
                    } else {
                        hm.put(array[i], 1);
                    }
                }

                int max = Integer.MIN_VALUE;
                int index = 0;
                for (int j = 0; j < hm.size(); j++) {
                    if (max < (int) hm.values().toArray()[j]) {
                        max = (int) hm.values().toArray()[j];
                        index = j;
                    }
                }

                if (max > array.length / 2) {
                    System.out.println(hm.keySet().toArray()[index]);
                } else {
                    System.out.println("None");
                }

                hm.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
