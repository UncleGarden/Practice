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
import java.util.Hashtable;

/**
 *
 * @author Jiateng
 */
public class StringList {

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

                Hashtable<Integer, Character> ht = new Hashtable();

                String[] lineArray = line.split(",");

                if (lineArray.length > 0) {
                    int len = Integer.valueOf(lineArray[0]);
                    String str = lineArray[1];

                    char[] array = str.toCharArray();
                    //得到所有的不重复的字母
                    for (int i = 0; i < str.length(); i++) {
                        if (ht.containsKey(str.charAt(i))) {
                            continue;
                        } else {
                            //System.out.println(array[i]);
                            ht.put((int) str.charAt(i), array[i]);
                        }
                    }

                    ArrayList<String> list = new ArrayList<String>();
                    String letters = "";

                    //字母顺序从小到大
                    int count = 0;
                    for (int i = 97; i <= 122; i++) {
                        if (ht.containsKey(i)) {
                            letters += ht.get(i);
                            count++;
                        }
                    }
                    System.out.println(letters);

                    linkTogether("", letters, list, len);

                    //test
                    Hashtable ht2 = new Hashtable();
                    for (int i = 0; i < list.size(); i++) {
                        if (ht2.containsKey(list.get(i))) {
                            System.out.println("Error." + i);
                        } else {
                            ht2.put(list.get(i), i);
                        }
                    }

                    //System.out.println(list.toString());
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i));
                        if (i < list.size() - 1) {
                            System.out.print(",");
                        }
                    }
                    System.out.println();

                    //System.out.println(ht.values().toArray()[0]);
                    //根据ASCII大小，大的是最上层，即[0]
                    //System.out.println(ht.toString());
//                    Hashtable<Integer, Character> ht2 = new Hashtable();
//                    int count = 0;
//                    for (int i = 97; i <= 122; i++) {
//                        if (ht.containsKey(i)) {
//                            ht2.put(count + 1, ht.get(i));
//                            count++;
//                        }
//                    }
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void linkTogether(String pre, String letters, ArrayList<String> list, int len) {

        if (pre.length() == len) {
            list.add(pre);
        } else {
            for (int i = 0; i < letters.length(); i++) {
                String cur = pre + letters.substring(i, i + 1);
                linkTogether(cur, letters, list, len);
            }
        }
    }
}
