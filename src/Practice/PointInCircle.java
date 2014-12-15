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
 * @author Garden
 */
public class PointInCircle {

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
        //reg. Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)
        //([0-9.\\-]+), if -, if 0-9, if . ; one or more times.
        String patternString = "Center: \\(([0-9.\\-]+), ([0-9.\\-]+)\\); Radius: ([0-9.\\-]+); Point: \\(([0-9.\\-]+), ([0-9.\\-]+)\\)";
        Pattern pattern = Pattern.compile(patternString);

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                Matcher m = pattern.matcher(line);

                if (m.find()) {
                    double cx = Double.valueOf(m.group(1));
                    double cy = Double.valueOf(m.group(2));
                    double length = Double.valueOf(m.group(3));
                    double px = Double.valueOf(m.group(4));
                    double py = Double.valueOf(m.group(5));

                    double distance = Math.sqrt(Math.pow((py - cy), 2) + Math.pow((px - cx), 2));

                    if (distance < length) {
                        System.out.println(true);
                    } else {
                        System.out.println(false);
                    }

                } else {
                    System.out.println("No Match.");
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
