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
import java.util.HashMap;

/**
 *
 * @author Garden
 */
public class StringSubstitution {

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
        HashMap<String, String> hm = new HashMap<String, String>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(";");

                String s = array[0];

                String[] reList = array[1].split(",");

                //every two numbers
                for (int i = 0; i < reList.length; i = i + 2) {
                    //get the length of replace number
                    int len = reList[i].length();

                    for (int j = 0; j <= s.length() - len;) {
                        //if match, replace the current subString, position change with length
                        //subString from 1-s.length
                        if (s.substring(j, j + len).equals(reList[i])) {
                            //s = s.replace(s.substring(j, j + len), reList[i + 1]);
                            char temp = (char) (i + 65);
                            s = s.replace(s.substring(j, j + len), String.valueOf(temp));
                            j = j + len;
                            hm.put(String.valueOf(temp), reList[i + 1]);
                            //System.out.println("replace");
                            //System.out.println(s);
                        } else {
                            j++;
                        }
                    }
                }

                //after all, replace back
                for (int k = 0; k < s.length(); k++) {
                    if (hm.containsKey(s.substring(k, k + 1))) {
                        s = s.replace(s.substring(k, k + 1), hm.get(s.substring(k, k + 1)));
                    }
                }

                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
