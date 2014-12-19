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
public class RomanNumberals {

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

                int number = Integer.valueOf(line);

                while (number != 0) {
                    if (number / 1000 > 0) {
                        number -= 1000;
                        result += "M";
                    } else if (number / 900 > 0) {
                        number -= 900;
                        result += "CM";
                    } else if (number / 500 > 0) {
                        number -= 500;
                        result += "D";
                    } else if (number / 400 > 0) {
                        number -= 400;
                        result += "CD";
                    } else if (number / 100 > 0) {
                        number -= 100;
                        result += "C";
                    } else if (number / 90 > 0) {
                        number -= 90;
                        result += "XC";
                    } else if (number / 50 > 0) {
                        number -= 50;
                        result += "L";
                    } else if (number / 40 > 0) {
                        number -= 40;
                        result += "XL";
                    } else if (number / 10 > 0) {
                        number -= 10;
                        result += "X";
                    } else if (number / 9 > 0) {
                        number -= 9;
                        result += "IX";
                    } else if (number / 5 > 0) {
                        number -= 5;
                        result += "V";
                    } else if (number / 4 > 0) {
                        number -= 4;
                        result += "IV";
                    } else if (number / 1 > 0) {
                        number -= 1;
                        result += "I";
                    }
                }

                System.out.println(result);
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
