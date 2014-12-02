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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Garden
 */
public class FindASquare {

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
        //reg. \\表示插入，[\\d-]+ 表示插入数字，- 表示0~9， + 表示重复一次或者多次
        String patternString = "\\b([\\d-]+,[\\d-]+)\\b";
        Pattern pattern = Pattern.compile(patternString);

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Matcher m = pattern.matcher(line);
                ArrayList<Integer> xs = new ArrayList<Integer>();
                ArrayList<Integer> ys = new ArrayList<Integer>();
                ArrayList<String> ps = new ArrayList<String>();
                ps.add("test");
                //System.out.println(ps.size());

                while (m.find()) {
                    String str = m.group(1);
                    String[] array = str.split(",");

                    boolean flag = true;
                    for (int i = 0; i < ps.size(); i++) {
                        if (ps.get(i).equals(str)) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        ps.add(str);
                    }
                    xs.add(Integer.valueOf(array[0]));
                    ys.add(Integer.valueOf(array[1]));
                }

                //System.out.println(ps.size());
                if (ps.size() != 5) {
                    System.out.println(false);
                    continue;
                }

                double distance1 = Math.sqrt(Math.pow((xs.get(0) - xs.get(1)), 2) + Math.pow((ys.get(0) - ys.get(1)), 2));
                //System.out.println(distance1);
                double distance2 = Math.sqrt(Math.pow((xs.get(0) - xs.get(2)), 2) + Math.pow((ys.get(0) - ys.get(2)), 2));
                //System.out.println(distance2);
                double distance3 = Math.sqrt(Math.pow((xs.get(0) - xs.get(3)), 2) + Math.pow((ys.get(0) - ys.get(3)), 2));
                //System.out.println(distance3);
                double distance4 = Math.sqrt(Math.pow((xs.get(3) - xs.get(1)), 2) + Math.pow((ys.get(3) - ys.get(1)), 2));
                //System.out.println(distance4);
                double distance5 = Math.sqrt(Math.pow((xs.get(3) - xs.get(2)), 2) + Math.pow((ys.get(3) - ys.get(2)), 2));
                //System.out.println(distance5);
                double distance6 = Math.sqrt(Math.pow((xs.get(2) - xs.get(1)), 2) + Math.pow((ys.get(2) - ys.get(1)), 2));
                //System.out.println(distance6);

                DecimalFormat df = new DecimalFormat("0.000000");

                if (distance1 == distance2 && distance1 == distance4 && distance1 == distance5 && df.format(distance1 * Math.sqrt(2)).equals(df.format(distance3))) {
                    System.out.println(true);
                } else if (distance1 == distance3 && distance1 == distance5 && distance1 == distance6 && df.format(distance1 * Math.sqrt(2)).equals(df.format(distance2))) {
                    System.out.println(true);
                } else if (distance2 == distance3 && distance2 == distance4 && distance2 == distance6 && df.format(distance2 * Math.sqrt(2)).equals(df.format(distance1))) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
