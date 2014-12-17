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
public class ReverseGroups {

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
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(";");

                int index = Integer.valueOf(array[1]);

                String[] list = array[0].split(",");

                if (index <= 1 || index > list.length) {
                    for (int k = 0; k < list.length; k++) {
                        result.add(list[k]);
                    }
                } else {
                    int count = 0;
                    for (int i = 0; i < list.length; i++) {
                        if (count != index) {
                            temp.add(0, list[i]);
                            count++;
                            if (i == list.length - 1) {
                                if (count == index) {
                                    while (!temp.isEmpty()) {
                                        result.add(temp.remove(0));
                                    }
                                } else {
                                    while (!temp.isEmpty()) {
                                        result.add(temp.remove(temp.size() - 1));
                                    }
                                }
                            }
                        } else {
                            while (!temp.isEmpty()) {
                                result.add(temp.remove(0));
                            }
                            temp.add(0, list[i]);
                            count = 1;
                            if (i == list.length - 1) {
                                while (!temp.isEmpty()) {
                                    result.add(temp.remove(temp.size() - 1));
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < result.size(); j++) {
                    System.out.print(result.get(j));
                    if (j != result.size() - 1) {
                        System.out.print(",");
                    }
                }

                System.out.println();
                result.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
