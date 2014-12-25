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
//import java.util.Collections;

/**
 *
 * @author Garden
 */
public class TelephoneWords {

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
        String[] trans = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list = new ArrayList<String>();
        String s = "";

        try {
            while ((line = in.readLine()) != null) {

                generate(list, 0, line, trans, s);

//                Collections.sort(list);
//                
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));

                    if (i < list.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                list.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    private static void generate(ArrayList<String> a, int count, String digits, String[] trans, String s) {

        if (count == digits.length()) {
            a.add(s);
            return;
        }

        // 0 ~ 9 --- 48 ~ 57
        int x = digits.charAt(count) - 48;

        for (int i = 0; i < trans[x].length(); i++) {
            //add
            s = s + trans[x].charAt(i);
            //recursive
            generate(a, count + 1, digits, trans, s);
            //copy the current one for back tracking 每次添加到list之后回到这一步，拷贝添加到list之前的string，再操作
            s = s.substring(0, s.length() - 1);
        }
    }
}
