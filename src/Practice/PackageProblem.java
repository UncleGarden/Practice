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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Garden
 */
public class PackageProblem {

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
        //reg. 
        String patternString = "^\\(([\\d-]+),([\\d-]+)[.]([\\d-]+),[$]([\\d-]+)\\)$";
        Pattern pattern = Pattern.compile(patternString);
        ArrayList<String> weights = new ArrayList<String>();
        ArrayList<Integer> costs = new ArrayList<Integer>();

        try {
            while ((line = in.readLine()) != null) {
                //if empty line, jump this line
                if (line.isEmpty()) {
                    continue;
                }
                //seperate by space, get the total weight first.
                String[] array = line.split("\\s+");

                Double totalWeight = Double.valueOf(array[0]);
                //System.out.println(totalWeight);

                for (int i = 2; i < array.length; i++) {
                    //System.out.println(array[i]);
                    Matcher m = pattern.matcher(array[i]);

                    if (m.find()) {
                        //int index = Integer.valueOf(m.group(1));

                        String weightNum = m.group(2);
                        String weightDec = m.group(3);
                        String weight = weightNum + "." + weightDec;
                        //System.out.println(weight);
                        weights.add(weight);

                        int cost = Integer.valueOf(m.group(4));
                        costs.add(cost);
                    } else {
                        System.out.println("NOT FIND!");
                    }
                }
                ArrayList<Integer> wei = new ArrayList();
                wei.add(null);
                ArrayList<ArrayList<Integer>> list = new ArrayList();
                checkWeight(totalWeight, weights, costs, 0, wei, list);

                int max = Integer.MIN_VALUE;
                int count = 0;

                for (int i = 0; i < list.size(); i++) {
                    //current add up
                    int current = 0;
                    //no fit thing in the package
                    if (list.size() == 1) {
                        System.out.print("-");
                        break;
                    }

                    for (int j = 1; j < list.get(i).size(); j++) {
                        current += costs.get(list.get(i).get(j));
                    }

                    if (current > max) {
                        max = current;
                        count = i;
                    } else if (current == max) {
                        double preW = 0;
                        for (int j = 1; j < list.get(count).size(); j++) {
                            preW += Double.valueOf(weights.get(list.get(count).get(j)));
                        }
                        double curW = 0;
                        for (int j = 1; j < list.get(i).size(); j++) {
                            curW += Double.valueOf(weights.get(list.get(i).get(j)));
                        }
                        if (curW < preW) {
                            count = i;
                        }
                    }
                }
                
                for (int k = 1; k < list.get(count).size(); k++) {
                    System.out.print(list.get(count).get(k) + 1);
                    if (k != list.get(count).size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();

                wei.clear();
                list.clear();
                weights.clear();
                costs.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void checkWeight(Double totalWeight, ArrayList<String> weights, ArrayList<Integer> costs, int index, ArrayList<Integer> ind, ArrayList<ArrayList<Integer>> list) {
        if (index == weights.size()) {
            if (!ind.isEmpty()) {
                list.add(ind);
            }
            return;
        }

        ArrayList<Integer> temp = new ArrayList<>(ind);
        double current = 0;

        current = totalWeight - Double.valueOf(weights.get(index));

        if (current >= 0) {
            temp.add(index);
            //add the index, ind list add one, pass the temp list
            checkWeight(current, weights, costs, index + 1, temp, list);
        }

        //go to the next index, ind list no change
        checkWeight(totalWeight, weights, costs, index + 1, ind, list);
    }
}
