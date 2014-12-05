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
public class HiddenDigits {

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
        String result = "";

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                for (int i = 0; i < line.length(); i++) {
                    String temp = line.substring(i, i + 1);
                    switch (temp) {
                        case "0":
                            result += temp;
                            break;
                        case "1":
                            result += temp;
                            break;
                        case "2":
                            result += temp;
                            break;
                        case "3":
                            result += temp;
                            break;
                        case "4":
                            result += temp;
                            break;
                        case "5":
                            result += temp;
                            break;
                        case "6":
                            result += temp;
                            break;
                        case "7":
                            result += temp;
                            break;
                        case "8":
                            result += temp;
                            break;
                        case "9":
                            result += temp;
                            break;
                        case "a":
                            result += "0";
                            break;
                        case "b":
                            result += "1";
                            break;
                        case "c":
                            result += "2";
                            break;
                        case "d":
                            result += "3";
                            break;
                        case "e":
                            result += "4";
                            break;
                        case "f":
                            result += "5";
                            break;
                        case "g":
                            result += "6";
                            break;
                        case "h":
                            result += "7";
                            break;
                        case "i":
                            result += "8";
                            break;
                        case "j":
                            result += "9";
                            break;
                    }
                }

                if (result.length() == 0) {
                    System.out.println("NONE");
                } else {
                    System.out.println(result);
                }
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
