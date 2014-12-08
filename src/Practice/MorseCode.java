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
public class MorseCode {

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

                String[] words = line.split("  ");

                for (int j = 0; j < words.length; j++) {
                    String[] array = words[j].split("\\s+");

                    for (int i = 0; i < array.length; i++) {
                        if (array[i].equals(".-")) {
                            System.out.print("A");
                        } else if (array[i].equals("-...")) {
                            System.out.print("B");
                        } else if (array[i].equals("-.-.")) {
                            System.out.print("C");
                        } else if (array[i].equals("-..")) {
                            System.out.print("D");
                        } else if (array[i].equals(".")) {
                            System.out.print("E");
                        } else if (array[i].equals("..-.")) {
                            System.out.print("F");
                        } else if (array[i].equals("--.")) {
                            System.out.print("G");
                        } else if (array[i].equals("....")) {
                            System.out.print("H");
                        } else if (array[i].equals("..")) {
                            System.out.print("I");
                        } else if (array[i].equals(".---")) {
                            System.out.print("J");
                        } else if (array[i].equals("-.-")) {
                            System.out.print("K");
                        } else if (array[i].equals(".-..")) {
                            System.out.print("L");
                        } else if (array[i].equals("--")) {
                            System.out.print("M");
                        } else if (array[i].equals("-.")) {
                            System.out.print("N");
                        } else if (array[i].equals("---")) {
                            System.out.print("O");
                        } else if (array[i].equals(".--.")) {
                            System.out.print("P");
                        } else if (array[i].equals("--.-")) {
                            System.out.print("Q");
                        } else if (array[i].equals(".-.")) {
                            System.out.print("R");
                        } else if (array[i].equals("...")) {
                            System.out.print("S");
                        } else if (array[i].equals("-")) {
                            System.out.print("T");
                        } else if (array[i].equals("..-")) {
                            System.out.print("U");
                        } else if (array[i].equals("...-")) {
                            System.out.print("V");
                        } else if (array[i].equals(".--")) {
                            System.out.print("W");
                        } else if (array[i].equals("-..-")) {
                            System.out.print("X");
                        } else if (array[i].equals("-.--")) {
                            System.out.print("Y");
                        } else if (array[i].equals("--..")) {
                            System.out.print("Z");
                        } else if (array[i].equals(".----")) {
                            System.out.print("1");
                        } else if (array[i].equals("..---")) {
                            System.out.print("2");
                        } else if (array[i].equals("...--")) {
                            System.out.print("3");
                        } else if (array[i].equals("....-")) {
                            System.out.print("4");
                        } else if (array[i].equals(".....")) {
                            System.out.print("5");
                        } else if (array[i].equals("-....")) {
                            System.out.print("6");
                        } else if (array[i].equals("--...")) {
                            System.out.print("7");
                        } else if (array[i].equals("---..")) {
                            System.out.print("8");
                        } else if (array[i].equals("----.")) {
                            System.out.print("9");
                        } else if (array[i].equals("-----")) {
                            System.out.print("0");
                        } else {
                            System.out.print(array[i]);
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
