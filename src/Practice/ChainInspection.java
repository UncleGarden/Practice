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
public class ChainInspection {

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

                String[] pairs = line.split(";");
                HashMap<String, String> hm = new HashMap<String, String>();
                for (int i = 0; i < pairs.length; i++) {
                    String[] s = pairs[i].split("-");
                    hm.put(s[0], s[1]);
                }

                String key = "";
                if (hm.containsKey("BEGIN")) {
                    key = hm.get("BEGIN");
                }else {
                    System.out.println("BAD");
                    continue;
                }

                int size = hm.size() - 1;

                while (size > 0) {
                    if (hm.containsKey(key)) {
                        key = hm.get(key);
                    } else {
                        break;
                    }
                    size--;
                }

                if (!key.equals("END") || size != 0) {
                    System.out.println("BAD");
                } else {
                    System.out.println("GOOD");
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
