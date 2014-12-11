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
public class NiceAngles {

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
        String result = "";

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split("\\.");

                //String min = getS(array[1]);
                double rest1 = Double.valueOf(line) - Double.valueOf(array[0]);
                String min = String.valueOf(rest1 * 60);
                String mins[] = min.split("\\.");

                double rest2 = Double.valueOf(min) - Double.valueOf(mins[0]);
                String sec = String.valueOf(rest2 * 60);
                String secs[] = sec.split("\\.");

                //String sec = getS(min.substring(2));
                if (mins[0].length() == 0) {
                    mins[0] = "00";
                } else if (mins[0].length() == 1) {
                    mins[0] = "0" + mins[0];
                }
                if (secs[0].length() == 0) {
                    secs[0] = "00";
                } else if (secs[0].length() == 1) {
                    secs[0] = "0" + secs[0];
                }

                result = array[0] + "." + mins[0] + "'" + secs[0] + "\"";

                System.out.println(result);
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static String getS(String num) {

        int[] t = new int[num.length()];
        for (int i = 0; i < t.length; i++) {
            t[i] = Integer.valueOf(num.substring(i, i + 1));
        }
        String result = "";
        int carry = 0;

        for (int i = t.length - 1; i >= 0; i--) {

            int temp = t[i] * 6;
            int cur = carry + temp;

            result = cur % 10 + result;

            //System.out.println(result);
            carry = cur / 10;
        }

        if (carry != 0) {
            result = carry + result;
        }

        result = result + 0;
        //System.out.println(result);
        return result;
    }
}
