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
import java.math.BigInteger;

/**
 *
 * @author Garden
 */
public class PredictTheNumber {

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

                //change the number to binary, the number might over the edge of Integer
                BigInteger bi = new BigInteger(line);
                String str = bi.toString(2);
                //System.out.println(str);
                char[] array = str.toCharArray();
                int total = 0;

                //每一个1，就是每次需要减去的最大的小于此数字的最大的2的指数值。 不用再使用例子中的减法算法来进行计算。
                //例如，5 - 0101， 需要减去4 余下1， 位置为1的数字进行一次变换 得到2
                //12 - 1100， 需要减去8，减去4 余下0， 位置为0的数字进行两次变换 得到2
                for (int i = 0; i < str.length(); i++) {
                    if (array[i] == '1') {
                        total++;
                    }
                }

                System.out.println(total % 3);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
