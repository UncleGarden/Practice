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
public class RollerCoaster {

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

                boolean flag = true;
                String result = "";

                for (int i = 0; i < line.length(); i++) {
                    String temp = line.substring(i, i + 1);
                    if (temp.matches("[a-zA-Z]")) {
                        if (flag) {
                            result += temp.toUpperCase();
                            flag = false;
                        } else {
                            result += temp.toLowerCase();
                            flag = true;
                        }
                    } else {
                        result += temp;
                    }
                }

                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
