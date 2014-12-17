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
public class RightmostChar {

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

                String[] array = line.split(",");

                String str1 = array[0];
                //System.out.println(str1);
                char[] list = str1.toCharArray();
                String str2 = array[1];
                int count = list.length;

                for (int i = list.length - 1; i >= 0; i--) {

                    count--;

                    //equals, 区别大小写。equalsIgnoreCase, 不区分大小写
                    if (str2.equals(Character.toString(list[i]))) {
                        System.out.println(count);
                        break;
                    }

                    if (i == 0) {
                        System.out.println("-1");
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
