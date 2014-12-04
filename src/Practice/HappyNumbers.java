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
import java.util.ArrayList;

/**
 *
 * @author Garden
 */
public class HappyNumbers {

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
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            while ((line = in.readLine()) != null) {

                if (isHappy(line, list)) {
                    System.out.println(1);
                    list.clear();
                } else {
                    System.out.println(0);
                    list.clear();
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static boolean isHappy(String num, ArrayList list) {

        Boolean flag = false;

        if (Integer.valueOf(num) == 1) {
            flag = true;
        } else {
            int result = 0;
            for (int i = 0; i < num.length(); i++) {
                result += Math.pow(Integer.valueOf(num.substring(i, i + 1)), 2);
            }
            for (int j = 0; j < list.size(); j++) {
                if (result == (int) list.get(j)) {
                    return false;
                }
            }
            list.add(result);

            flag = isHappy(String.valueOf(result), list);
        }
        return flag;
    }
}
