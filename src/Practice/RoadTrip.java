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
import java.util.Arrays;

/**
 *
 * @author Garden
 */
public class RoadTrip {

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

                String[] array = line.split(";");
                int[] distance = new int[array.length];

                for (int i = 0; i < array.length; i++) {
                    String[] s = array[i].split(",");
                    distance[i] = Integer.valueOf(s[1]);
                }

                Arrays.sort(distance);

                for (int j = 0; j < distance.length; j++) {
                    if (j == 0) {
                        System.out.print(distance[j] + ",");
                    } else {
                        System.out.print(distance[j] - distance[j - 1]);
                        if (j != distance.length - 1) {
                            System.out.print(",");
                        }
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
