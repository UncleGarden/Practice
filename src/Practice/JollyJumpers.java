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
public class JollyJumpers {

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

                int amount = Integer.valueOf(array[0]);

                for (int i = 1; i < array.length - 1; i++) {
                    int dif = Math.abs(Integer.valueOf(array[i]) - Integer.valueOf(array[i + 1]));
                    System.out.println(dif);
                    if (dif >= amount || dif == 0 ||hm.containsKey(dif)) {
                        System.out.println("Not jolly");
                        break;
                    } else {
                        hm.put(dif, 1);
                    }
                }
                if (hm.size() == (amount - 1)) {
                    System.out.println("Jolly");
                }
                hm.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
