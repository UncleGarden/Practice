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
public class JsonMenuIDs {

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
        //reg. \将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\"匹配"\"，"\("匹配"("。
        //String patternString = "\"id\": (\\d+), \"label\"";
        //reg. \\b表示边界。 w3cschool
        String patternString = "\\bid\": (\\d+), \"label\\b";
        
        Pattern pattern = Pattern.compile(patternString);

        try {
            while ((line = in.readLine()) != null) {
                line = line.trim();

                if (line.length() == 0) {
                    continue;
                }

                Matcher m = pattern.matcher(line);

                int sum = 0;

                while (m.find()) {
                    sum += Integer.parseInt(m.group(1));
                }

                System.out.println(sum);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
