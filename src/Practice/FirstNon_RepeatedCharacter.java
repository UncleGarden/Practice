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
public class FirstNon_RepeatedCharacter {

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

                int i = 0;
                int j = 0;
                int count = 0;
                for (i = 0; i < line.length(); i++) {
                    for (j = 0; j < line.length(); j++) {
                        if (line.charAt(i) == line.charAt(j)) {
                            count++;
                        }
                    }
                    if (count == 1) {
                        System.out.println(line.substring(i, i + 1));
                        break;
                    } else {
                        count = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
