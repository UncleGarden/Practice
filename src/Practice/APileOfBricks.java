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
public class APileOfBricks {

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
        ArrayList<Integer> a = new ArrayList<Integer>();

        try {
            while ((line = in.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }
                //System.out.println(line);

                String area = "";
                String brick = "";
                String[] array = line.split("\\|+");

                String pattern = "[-\\d]+";
                Pattern r = Pattern.compile(pattern);

                //area part
                Matcher m1 = r.matcher(array[0]);

                while (m1.find()) {
                    if (m1.group().equals("-")) {
                        area += m1.group();
                    } else {
                        area += m1.group() + " ";
                    }
                }
                //System.out.println(area);
                String AREA = calArea(area);
                //System.out.println(AREA);
                String[] AREA_ = AREA.split(",");

                //loop the brick part
                String[] bricks = array[1].split(";");
                int size = bricks.length;
                while (size > 0) {
                    Matcher m2 = r.matcher(bricks[size - 1]);

                    while (m2.find()) {
                        if (m2.group().equals("-")) {
                            brick += m2.group();
                        } else {
                            brick += m2.group() + " ";
                        }
                    }
                    //System.out.println(brick);
                    String BRICK = calBrick(brick);
                    //System.out.println(BRICK);
                    String[] BRICK_ = BRICK.split(",");

                    if (Integer.valueOf(AREA_[0]) >= Integer.valueOf(BRICK_[0]) && Integer.valueOf(AREA_[1]) >= Integer.valueOf(BRICK_[1])) {
                        a.add(size);
                    } else if (Integer.valueOf(AREA_[0]) >= Integer.valueOf(BRICK_[2]) && Integer.valueOf(AREA_[1]) >= Integer.valueOf(BRICK_[3])) {
                        a.add(size);
                    } else if (Integer.valueOf(AREA_[0]) >= Integer.valueOf(BRICK_[4]) && Integer.valueOf(AREA_[1]) >= Integer.valueOf(BRICK_[5])) {
                        a.add(size);
                    }

                    size--;
                    brick = "";
                }

                if (a.size() == 0) {
                    System.out.print("-");
                }

                for (int i = a.size(); i > 0; i--) {
                    System.out.print(a.get(i - 1));
                    if (i != 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                a.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static String calArea(String area) {
        String result = "";
        int height = 0;
        int width = 0;

        String[] a = area.split("\\s+");
        height = Math.abs(Integer.valueOf(a[0]) - Integer.valueOf(a[2]));
        width = Math.abs(Integer.valueOf(a[1]) - Integer.valueOf(a[3]));
        //assume width > height
        if (height > width) {
            result += height;
            result += ",";
            result += width;
        } else {
            result += width;
            result += ",";
            result += height;
        }

        return result;
    }

    public static String calBrick(String brick) {
        String result = "";

        String[] a = brick.split("\\s+");
        //int a1 = Math.abs(Integer.valueOf(a[1]) - Integer.valueOf(a[4])) * Math.abs(Integer.valueOf(a[2]) - Integer.valueOf(a[5]));
        //int a2 = Math.abs(Integer.valueOf(a[1]) - Integer.valueOf(a[4])) * Math.abs(Integer.valueOf(a[3]) - Integer.valueOf(a[6]));
        //int a3 = Math.abs(Integer.valueOf(a[2]) - Integer.valueOf(a[5])) * Math.abs(Integer.valueOf(a[3]) - Integer.valueOf(a[6]));

        int h1 = Math.abs(Integer.valueOf(a[1]) - Integer.valueOf(a[4]));
        int w1 = Math.abs(Integer.valueOf(a[2]) - Integer.valueOf(a[5]));

        if (h1 > w1) {
            result += h1;
            result += ",";
            result += w1;
        } else {
            result += w1;
            result += ",";
            result += h1;
        }
        result += ",";
        int h2 = Math.abs(Integer.valueOf(a[1]) - Integer.valueOf(a[4]));
        int w2 = Math.abs(Integer.valueOf(a[3]) - Integer.valueOf(a[6]));
        if (h2 > w2) {
            result += h2;
            result += ",";
            result += w2;
        } else {
            result += w2;
            result += ",";
            result += h2;
        }
        result += ",";
        int h3 = Math.abs(Integer.valueOf(a[2]) - Integer.valueOf(a[5]));
        int w3 = Math.abs(Integer.valueOf(a[3]) - Integer.valueOf(a[6]));
        if (h1 > w1) {
            result += h3;
            result += ",";
            result += w3;
        } else {
            result += w3;
            result += ",";
            result += h3;
        }

        return result;
    }
}
