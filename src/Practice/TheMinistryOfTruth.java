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

/**
 *
 * @author Garden
 */
public class TheMinistryOfTruth {

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

                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split(";");
                String[] l1 = array[0].split("\\s+");
                String[] l2 = array[1].split("\\s+");

                if (l1.length < l2.length) {
                    System.out.println("I cannot fix history");
                }

                String str = "";
                String result = "";

                for (int i = 0; i < l1.length;) {
                    //System.out.println("I loop");
                    for (int j = 0; j < l2.length;) {
                        //System.out.println("J loop");
                        //System.out.println(l1[i].length());
                        //System.out.println(l2[j].length());

                        //if i length less than j
                        if (l1[i].length() < l2[j].length()) {
                            int lll = l1[i].length();
                            while (lll > 0) {

                                result += "_";
                                lll--;
                            }
                            if (j < l2.length) {
                                result += " ";
                            }
                            i++;
                            //if here, means that l2 is not finished. if i == l1.length, means, we can not match all the strings
                            if(i == l1.length){
                                System.out.println("I cannot fix history");
                                break;
                            }
                            continue;
                        }

                        //find the match
                        for (int k = 0; k < l1[i].length() - l2[j].length() + 1; k++) {
                            //System.out.println("For loop");
                            //System.out.println(k);
                            //System.out.println(l1[i].length());
                            //System.out.println(l2[j].length());
                            //System.out.println(l1[i].substring(k, k + l2[j].length()));
                            if (l1[i].substring(k, k + l2[j].length()).equals(l2[j])) {
                                //System.out.println("if condition");

                                str = add(k, l2[j], l1[i].length() - l2[j].length() - k);

                                result += str;
                                if (j < l2.length) {
                                    result += " ";
                                }
                                //System.out.println(result);
                                i++;
                                j++;
                                break;
                            } //not match 
                            else if (k == l1[i].length() - l2[j].length()) {
                                //System.out.println("else if condition");
                                int loop = l1[i].length();
                                while (loop > 0) {

                                    result += "_";
                                    loop--;
                                }
                                if (j < l2.length) {
                                    result += " ";
                                }
                                //System.out.println(result);
                                i++;
                                if (i == l1.length) {
                                    break;
                                }
                                //break, start from next k = 0
                                break;
                            }
                        }
                        //l1 loop to beyond the end.
                        if (i == l1.length && j != l2.length) {
                            System.out.println("I cannot fix history");
                            break;
                        }
                        //l2 loop to the end.
                        if (j == l2.length) {
                            if (i == l1.length) {
                                System.out.println(result);
                                break;
                            } else {
                                for (int l = i; l < l1.length; l++) {
                                    int len = l1[l].length();
                                    while (len > 0) {
                                        result += "_";
                                        len--;
                                    }
                                    if (l < l1.length) {
                                        result += " ";
                                    }
                                }
                                System.out.println(result);
                                break;
                            }
                        }
                    }
                    //System.out.println("break");
                    //if come to this loop, just break;
                    break;
                }

                //System.out.println("Finished !!!!!!!!!!!!!!!");
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static String add(int x, String s, int y) {

        String str = "";

        while (x > 0) {
            str += "_";
            x--;
        }

        str += s;

        while (y > 0) {
            str += "_";
            y--;
        }

        return str;
    }
}
