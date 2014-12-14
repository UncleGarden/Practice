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
public class OverlappingRectangles {

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

                //r1_left_x,r1_left_y,r1_right_x,r1_right_y
                //r2_left_x,r2_left_y,r2_right_x,r2_right_y
                String[] array = line.split(",");
                int r1lx = Integer.valueOf(array[0]);
                int r1ly = Integer.valueOf(array[1]);
                int r1rx = Integer.valueOf(array[2]);
                int r1ry = Integer.valueOf(array[3]);
                int r2lx = Integer.valueOf(array[4]);
                int r2ly = Integer.valueOf(array[5]);
                int r2rx = Integer.valueOf(array[6]);
                int r2ry = Integer.valueOf(array[7]);

                //whole left
                if (r1lx > r2rx || r1rx < r2lx) {
                    System.out.println("False");
                    continue;
                }

                //whole above
                if (r1ry > r2ly || r2ry > r1ly) {
                    System.out.println("False");
                    continue;
                }

                System.out.println("True");
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
