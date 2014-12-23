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
import java.util.Arrays;
import java.util.HashSet;

/**
 * 考虑一下多余两个的重复数字
 * 或者一排数字全都是一样的情况
 *
 * @author Garden
 */
public class SumToZero {

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

                String[] array = line.split(",");
                int[] num = new int[array.length];

                for (int i = 0; i < num.length; i++) {
                    num[i] = Integer.valueOf(array[i]);
                }

                Arrays.sort(num);

                for (int i = 0; i < num.length; i++) {
                    System.out.print(num[i] + " ");
                }
                System.out.println();

                HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

                for (int i = 0; i < num.length; i++) {
                    for (int j = i + 1; j < num.length; j++) {
                        int k = j + 1;
                        int l = num.length - 1;

                        //check all number inside the loop
                        while (k < l) {
                            int sum = Integer.valueOf(num[i]) + Integer.valueOf(num[j]) + Integer.valueOf(num[l]) + Integer.valueOf(num[k]);

                            //because the array is sort
                            if (sum > 0) {
                                l--;
                            } else if (sum < 0) {
                                k++;
                            } else if (sum == 0) {
                                ArrayList<Integer> temp = new ArrayList<Integer>();
                                temp.add(Integer.valueOf(num[i]));
                                temp.add(Integer.valueOf(num[j]));
                                temp.add(Integer.valueOf(num[k]));
                                temp.add(Integer.valueOf(num[l]));

                                result.add(temp);
                                //avoid duplicate 
//                                if (!hashSet.contains(temp)) {
//                                    hashSet.add(temp);
//                                    result.add(temp);
//                                }
                                if (num[k] == num[k + 1]) {
                                    k++;
                                } else if (num[l] == num[l - 1]) {
                                    l--;
                                } else {
                                    k++;
                                    l--;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i).toString());
                }
                System.out.println(result.size());
                System.out.println("==================================");
                hashSet.clear();
                result.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
