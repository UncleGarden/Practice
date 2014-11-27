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
 * In this challenge you're presented with a situation in which you need to
 * output big symbols on devices which only support ASCII characters and single,
 * fixed-width fonts. To do this you're going to use pseudo-graphics to ‘draw’
 * these big symbols.
 *
 * @author Jiateng
 */
public class BigDigits {

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
        // 5 * 6 pixels
        String l1 = "-**----*--***--***---*---****--**--****--**---**--";
        String l2 = "*--*--**-----*----*-*--*-*----*-------*-*--*-*--*-";
        String l3 = "*--*---*---**---**--****-***--***----*---**---***-";
        String l4 = "*--*---*--*-------*----*----*-*--*--*---*--*----*-";
        String l5 = "-**---***-****-***-----*-***---**---*----**---**--";
        String l6 = "--------------------------------------------------";

        try {
            while ((line = in.readLine()) != null) {
                String t1 = "";
                String t2 = "";
                String t3 = "";
                String t4 = "";
                String t5 = "";
                String t6 = "";
                int count = 5;
                
                for(int i = 0; i < line.length(); i++){

                    int temp = line.charAt(i)-'0';
                    if(temp >= 0 && temp <= 9){
                        t1 += l1.substring(count*temp, count*temp+5);
                        t2 += l2.substring(count*temp, count*temp+5);
                        t3 += l3.substring(count*temp, count*temp+5);
                        t4 += l4.substring(count*temp, count*temp+5);
                        t5 += l5.substring(count*temp, count*temp+5);
                        t6 += l6.substring(count*temp, count*temp+5);
                    }
                }
                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
                System.out.println(t5);
                System.out.println(t6);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
