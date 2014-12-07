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
public class LowestUniqueNumber {

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
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        try {
            while ((line = in.readLine()) != null) {

                String[] array = line.split("\\s+");

                int count = 0;
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i].equals(array[j])) {
                            count++;
                        }
                    }
                    if (count == 1) {
                        hm.put(i, Integer.valueOf(array[i]));
                    }
                    count = 0;
                }

                if (hm.isEmpty()) {
                    System.out.println(0);
                } else {
                    int min = Integer.MAX_VALUE;
                    int index = 0;
                    for (int i = 0; i < hm.size(); i++) {
                        if ((int) hm.values().toArray()[i] < min) {
                            min = (int) (hm.values().toArray()[i]);
                            index = (int) hm.keySet().toArray()[i] + 1;
                        }
                    }
                    System.out.println(index);
                }
                hm.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
