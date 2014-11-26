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
public class BatsChallenge {

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

                String[] array = line.split("\\s+");

                int length = Integer.valueOf(array[0]);
                int dis = Integer.valueOf(array[1]);
                int num = Integer.valueOf(array[2]);
                int result = 0;

                if (num == 0) {
                    result = (length - 12) / dis + 1;
                } else {
                    //hanged bats
                    for (int i = 3; i < num + 3; i++) {
                        if (i == 3) {
                            result += (Integer.valueOf(array[i]) - 6) / dis;
                        } else {
                            result += (Integer.valueOf(array[i]) - Integer.valueOf(array[i - 1])) / dis - 1;
                        }

                        if (i == num + 3 - 1) {
                            result += (length - 6 - Integer.valueOf(array[i])) / dis;
                        }
                    }
                }

                System.out.println(result);

            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
