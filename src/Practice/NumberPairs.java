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
public class NumberPairs {

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
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(";");

                int amount = Integer.valueOf(array[1]);

                String[] nums = array[0].split(",");

                check(nums, amount, list, 0, 0);

                if (list.isEmpty()) {
                    System.out.println("NULL");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = 0; j < list.get(i).size(); j++) {
                            System.out.print(list.get(i).get(j));
                            if (j != list.get(i).size() - 1) {
                                System.out.print(",");
                            }
                        }
                        if (i != list.size() - 1) {
                            System.out.print(";");
                        }
                    }
                    System.out.println();
                }
                list.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void check(String[] nums, int amount, ArrayList<ArrayList<Integer>> list, int step, int index) {

        if (index == nums.length) {
            return;
        }

        int cur = amount;

        for (int i = index; i < nums.length; i++) {
            if (step == 0 && cur - Integer.valueOf(nums[i]) > 0) {
                step++;
                cur = cur - Integer.valueOf(nums[i]);
                continue;
            }

            if (step == 1 && cur - Integer.valueOf(nums[i]) == 0) {

                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(amount - cur);
                temp.add(cur);
                list.add(temp);
                step = 0;
                break;
            }

            if (i == nums.length - 1) {
                step = 0;
            }
        }

        check(nums, amount, list, step, index + 1);
    }
}
