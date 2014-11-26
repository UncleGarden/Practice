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
import java.util.Stack;

/**
 *
 * @author Garden
 */
public class BalancedSmileys {

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

                String temp1 = line.replace(":(", "{");
                String temp2 = temp1.replace(":)", "}");
                char[] c = temp2.toCharArray();
                Stack<Character> open = new Stack();
                Stack<Character> happy = new Stack();
                Stack<Character> sad = new Stack();

                for (int i = 0; i < c.length; i++) {
                    if (c[i] == '(') {
                        open.push('(');
                    }
                    if (c[i] == '{') {
                        happy.push('{');
                    }
                    if (c[i] == ')') {
                        if (!open.isEmpty()) {
                            open.pop();
                        } else if (!happy.isEmpty()) {
                            happy.pop();
                        } else {
                            System.out.println("NO");
                            break;
                        }
                    }
                    if (c[i] == '}') {
                        sad.push('}');
                    }

                    if (i == c.length - 1) {
                        if (open.isEmpty()) {
                            System.out.println("YES");
                        }
                        //check open
                        if (!open.isEmpty()) {
                            if (open.size() <= sad.size()) {
                                System.out.println("YES");
                            } else {
                                System.out.println("NO");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
