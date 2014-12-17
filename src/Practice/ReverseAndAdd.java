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
public class ReverseAndAdd {

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
                if (line.length() == 0) {
                    continue;
                }
                
                StringBuilder sb = new StringBuilder(line);
                int count = 0;
                boolean flag = true;
                
                while (flag && count <= 100) {
                    //different length of new sb
                    int n = sb.length();
                    char[] ch = sb.toString().toCharArray();
                    //a new empty sb
                    sb = new StringBuilder();
                    flag = false;
                    int add = 0;
                    for (int i = 0; i < n; i++) {
                        //reverse and add: add from begin && from end
                        int sum = ch[i] + ch[n - 1 - i] - 2 * '0' + add;
                        sb.insert(0, sum % 10);
                        add = sum / 10;
                        //larger than 10, or if no add > 10, this is the answer
                        if (add > 0) {
                            flag = true;
                        }
                    }
                    if (add > 0) {
                        sb.insert(0, add);
                    }
                    count++;
                }
                System.out.println(count + " " + (new String(sb)));
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
