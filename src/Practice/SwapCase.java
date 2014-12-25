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
public class SwapCase {

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
                char[] array = line.toCharArray();

                for (int i = 0; i < array.length; i++) {
                    if (line.charAt(i) >= 65 && line.charAt(i) <= 90) {
                        result += String.valueOf((char) (line.charAt(i) + 32));
                    }
                    else if (line.charAt(i) >= 97 && line.charAt(i) <= 122) {
                        result += String.valueOf((char) (line.charAt(i) - 32));
                    }else{
                    result += String.valueOf((char) (line.charAt(i)));
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
