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
public class DecodeNumbers {

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

                int result = count(line);

                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static int count(String line) {

        if (line.length() == 1 || line.length() == 0) {
            return 1;
        }

        int possibilities = 0;
        int num_chars = 1;

        while (true) {
            
            if(num_chars > line.length()){
                break;
            }
            
            String str = line.substring(0, num_chars);

            //for python to check if the str is out of the range of line
//            if (str.length() != num_chars) {
//                break;
//            }

            if (Integer.valueOf(str) > 26) {
                break;
            }

            possibilities += count(line.substring(num_chars, line.length()));
            num_chars += 1;
        }

        return possibilities;
    }
}
