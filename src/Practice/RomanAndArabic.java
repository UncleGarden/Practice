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
import java.util.HashMap;

/**
 *
 * @author Garden
 */
public class RomanAndArabic {

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
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);

        try {
            while ((line = in.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }

                ArrayList<Integer> list = new ArrayList<Integer>();

                int pre = hm.get(line.substring(1, 2));

                for (int i = 3; i < line.length(); i = i + 2) {
                    int cur = hm.get(line.substring(i, i + 1));
                    //System.out.println(cur);
                    if (cur > pre) {
                        list.add(-pre);
                    } else {
                        list.add(pre);
                    }
                    pre = cur;

                    if (i + 2 >= line.length()) {
                        list.add(pre);
                    }
                }
                
                int total = 0;
                
                if(line.length() == 2){
                    total = Integer.valueOf(line.substring(0, 1)) * hm.get(line.substring(1, 2));
                }
                
                for(int j = 0; j < list.size(); j++){
                    int k = Integer.valueOf(line.substring(2*j, 2*j+1));

                    total += k * list.get(j);
                }
                
                System.out.println(total);
                list.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
