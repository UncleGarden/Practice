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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jiateng
 */
public class CalculateDistance {

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
        String patternString = "^\\(([\\d-]+), ([\\d-]+)\\) \\(([\\d-]+), ([\\d-]+)\\)$";
        Pattern pattern = Pattern.compile(patternString);

        try {
            while ((line = in.readLine()) != null) {
                Matcher m = pattern.matcher(line);

                if (m.find()) {
                    int x1 = Integer.parseInt(m.group(1));
                    int y1 = Integer.parseInt(m.group(2));
                    int x2 = Integer.parseInt(m.group(3));
                    int y2 = Integer.parseInt(m.group(4));

                    int distance = (int) Math.sqrt(Math.abs(x2 - x1) * Math.abs(x2 - x1) + Math.abs(y2 - y1) * Math.abs(y2 - y1));

                    System.out.println(distance);
                } else {
                    System.out.println("No Match.");
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
