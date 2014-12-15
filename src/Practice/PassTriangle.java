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
public class PassTriangle {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

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

                ArrayList<Integer> temp = new ArrayList<Integer>();

                String[] array = line.split("\\s+");

                for (int i = 0; i < array.length; i++) {
                    temp.add(Integer.valueOf(array[i]));
                }

                tree.add(temp);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }

        pass(tree.size());
    }

    //nice algorithm
    public static void pass(int n) {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (tree.get(i + 1).get(j) > tree.get(i + 1).get(j + 1)) {
                    tree.get(i).set(j, tree.get(i + 1).get(j) + tree.get(i).get(j));
                } else {
                    tree.get(i).set(j, tree.get(i + 1).get(j + 1) + tree.get(i).get(j));
                }
            }
        }
        System.out.println(tree.get(0).get(0));
    }
}
