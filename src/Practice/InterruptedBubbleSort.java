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
public class InterruptedBubbleSort {

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

                String[] array = line.split("\\| ");
                String[] nums = array[0].split("\\s+");
                long times = Long.valueOf(array[1]);
                int count = 0;

                while (times > 0) {
                    for (int i = 0; i < nums.length - 1; i++) {
                        if (Integer.valueOf(nums[i]) > Integer.valueOf(nums[i + 1])) {
                            String temp = nums[i + 1];
                            nums[i + 1] = nums[i];
                            nums[i] = temp;
                        }
                    }
                    times--;
                    count++;
                    //worst case N*N
                    if (count > nums.length * nums.length) {
                        break;
                    }
                }

                for (int j = 0; j < nums.length; j++) {
                    System.out.print(nums[j]);
                    if (j != nums.length - 1) {
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
