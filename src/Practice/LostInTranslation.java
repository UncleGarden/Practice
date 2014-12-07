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
public class LostInTranslation {

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
        String result = "";
        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                char[] array = line.toCharArray();

                for (int i = 0; i < array.length; i++) {
                    switch (array[i]) {
                        case 'a': result += "y"; break;
                        case 'b': result += "h"; break;
                        case 'c': result += "e"; break;
                        case 'd': result += "s"; break;
                        case 'e': result += "o"; break;
                        case 'f': result += "c"; break;
                            //from the description
                        case 'g': result += "v"; break;
                            //the only one mapping left
                        case 'h': result += "x"; break;
                        case 'i': result += "d"; break;
                        case 'j': result += "u"; break;
                        case 'k': result += "i"; break;
                        case 'l': result += "g"; break;
                        case 'm': result += "l"; break;
                        case 'n': result += "b"; break;
                        case 'o': result += "k"; break;
                        case 'p': result += "r"; break;
                        case 'q': result += "z"; break;
                        case 'r': result += "t"; break;
                        case 's': result += "n"; break;
                        case 't': result += "w"; break;
                        case 'u': result += "j"; break;
                        case 'v': result += "p"; break;
                        case 'w': result += "f"; break;
                        case 'x': result += "m"; break;
                        case 'y': result += "a"; break;
                        case 'z': result += "q"; break;
                        case ' ': result += " "; break;
                    }
                }
                System.out.println(result);
                result = "";
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
