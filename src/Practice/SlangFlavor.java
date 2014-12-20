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
 * @author Jiateng
 */
public class SlangFlavor {

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
        int count = 0;
        int index = 1;

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, ", yeah!");
        hm.put(2, ", this is crazy, I tell ya.");
        hm.put(3, ", can U believe this?");
        hm.put(4, ", eh?");
        hm.put(5, ", aw yea.");
        hm.put(6, ", yo.");
        hm.put(7, "? No way!");
        hm.put(0, ". Awesome!");
        
        try {
            while ((line = in.readLine()) != null) {
                
                char[] array = line.toCharArray();

                for (int i = 0; i < array.length; i++) {
                    
                    if(array[i] == '.' || array[i] == '!' || array[i] == '?'){
                        count++;
                    }

                    if (array[i] == '.' && count % 2 == 0) {
                        result += hm.get(index % 8);
                        index++;
                    } else if (array[i] == '!' && count % 2 == 0) {
                        result += hm.get(index % 8);
                        index++;
                    } else if (array[i] == '?' && count % 2 == 0) {
                        result += hm.get(index % 8);
                        index++;
                    } else {
                        result += array[i];
                    }
                }

                System.out.println(result);
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
