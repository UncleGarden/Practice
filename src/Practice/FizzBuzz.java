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
public class FizzBuzz {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file input.");
        }
        String line;
        String result = "";
        try {
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s+");
                if (lineArray.length > 0) {
                    int fizz = Integer.valueOf(lineArray[0]);
                    int buzz = Integer.valueOf(lineArray[1]);
                    int n = Integer.valueOf(lineArray[2]);

                    for (int i = 1; i <= n; i++) {
                        //not equal to (i % (fizz * buzz)), 质数才可以。 比如4,6就不对了。 24的话会错过12。
                        if (i % fizz == 0 && i % buzz == 0) {
                            result += "FB";
                        } else if (i % fizz == 0) {
                            result += "F";
                        } else if (i % buzz == 0) {
                            result += "B";
                        } else {
                            result += i;
                        }
                        if (i != n) {
                            result += " ";
                        }
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
