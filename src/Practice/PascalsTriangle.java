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
public class PascalsTriangle {

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

                int level = Integer.valueOf(line);
                int size = 0;

                int[] cur = new int[1];
                while (level > 0) {
                    size++;
                    int[] temp = new int[size];

                    if (size == 1) {
                        temp[0] = 1;
                    } else if (size == 2) {
                        temp[0] = 1;
                        temp[1] = 1;
                    } else {
                        temp[0] = 1;
                        for (int i = 0; i < cur.length - 1; i++) {
                            temp[i + 1] = cur[i] + cur[i + 1];
                        }
                        temp[size - 1] = 1;
                    }

                    //add into result
                    for (int j = 0; j < temp.length; j++) {
                        result = result + temp[j] + " ";
                    }
                    cur = temp;

                    level--;
                }
                System.out.println(result.substring(0, result.length() - 1));
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
