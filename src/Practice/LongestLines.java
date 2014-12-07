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
public class LongestLines {

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
        int num = 0;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        try {
            while ((line = in.readLine()) != null) {
                if (num == 0) {
                    num = Integer.valueOf(line);
                    continue;
                }
                list.add(line);
                len.add(line.length());
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }

        int index = 0;
        for (int i = 0; i < num; i++) {
            index = findLongest(0, len);
            System.out.println(list.get(index-1));
            len.remove(index - 1);
            len.add(index - 1, 0);
        }
    }

    public static int findLongest(int step, ArrayList len) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < len.size(); i++) {
            if ((int) len.get(i) > max) {
                max = (int) len.get(i);
                index = i + 1;
            }
        }
        return index;
    }
}
