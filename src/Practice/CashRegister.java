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
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Garden
 */
public class CashRegister {

    public static ArrayList<String> list = new ArrayList();

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

                String[] array = line.split(";");

                double dif = Double.valueOf(array[1]) - Double.valueOf(array[0]);
                DecimalFormat result = new DecimalFormat("0.00");

                check(result.format(dif));

                if (list.isEmpty()) {
                    continue;
                }

                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if (i < list.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                list.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static void check(String s) {

        double temp = Double.valueOf(s);
        DecimalFormat result = new DecimalFormat("0.00");

        if (temp < 0) {
            System.out.println("ERROR");
        } else if (temp == 0) {
            System.out.println("ZERO");
        } else {
            while (temp > 0) {
                if (temp - 100 >= 0) {
                    //if (avaliable("ONE HUNDRED")) {
                    list.add("ONE HUNDRED");
                    //}
                    temp = temp - 100;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 50 >= 0) {
                    //if (avaliable("FIFTY")) {
                    list.add("FIFTY");
                    //}
                    temp = temp - 50;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 20 >= 0) {
                    //if (avaliable("TWENTY")) {
                    list.add("TWENTY");
                    //}
                    temp = temp - 20;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 10 >= 0) {
                    //if (avaliable("TEN")) {
                    list.add("TEN");
                    //}
                    temp = temp - 10;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 5 >= 0) {
                    //if (avaliable("FIVE")) {
                    list.add("FIVE");
                    //}
                    temp = temp - 5;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 2 >= 0) {
                    //if (avaliable("TWO")) {
                    list.add("TWO");
                    //}
                    temp = temp - 2;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 1 >= 0) {
                    //if (avaliable("ONE")) {
                    list.add("ONE");
                    //}
                    temp = temp - 1;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 0.5 >= 0) {
                    //if (avaliable("HALF DOLLAR")) {
                    list.add("HALF DOLLAR");
                    //}
                    temp = temp - 0.5;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 0.25 >= 0) {
                    //if (avaliable("QUARTER")) {
                    list.add("QUARTER");
                    //}
                    temp = temp - 0.25;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 0.10 >= 0) {
                    //if (avaliable("DIME")) {
                    list.add("DIME");
                    //}
                    temp = temp - 0.1;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 0.05 >= 0) {
                    //if (avaliable("NICKEL")) {
                    list.add("NICKEL");
                    //}
                    temp = temp - 0.05;
                    temp = Double.valueOf(result.format(temp));
                } else if (temp - 0.01 >= 0) {
                    //if (avaliable("PENNY")) {
                    list.add("PENNY");
                    //}
                    temp = temp - 0.01;
                    temp = Double.valueOf(result.format(temp));
                }
            }
        }
    }

//    public static boolean avaliable(String ss) {
//        boolean flag = true;
//
//        for (String pre : list) {
//            if (pre.equals(ss)) {
//                flag = false;
//            }
//        }
//        return flag;
//    }
}
