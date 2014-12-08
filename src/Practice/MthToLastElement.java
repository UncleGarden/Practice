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
 * @author Jiateng
 */
public class MthToLastElement {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file input.");
        }
        String line;

        try {
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s+");

                if (Integer.valueOf(lineArray[lineArray.length - 1]) < lineArray.length) {
                    System.out.println(lineArray[lineArray.length - 1 - Integer.valueOf(lineArray[lineArray.length - 1])]);
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
