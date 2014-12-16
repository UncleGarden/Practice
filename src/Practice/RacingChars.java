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

/**
 *
 * @author Garden
 */
public class RacingChars {

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
        int route = 0;
        ArrayList<Integer> checkPoints = new ArrayList<>();
        ArrayList<Integer> gates = new ArrayList<>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                if (route == 0) {
                    for (int i = 0; i < line.length(); i++) {
                        if (line.substring(i, i + 1).equals("C")) {
                            checkPoints.add(i);
                        }
                        if (line.substring(i, i + 1).equals("_")) {
                            gates.add(i);
                        }
                    }
                    if (!checkPoints.isEmpty()) {
                        System.out.println(line.replace("C", "|"));
                        route = checkPoints.remove(0);
                    } else {
                        System.out.println(line.replace("_", "|"));
                        route = gates.remove(0);
                    }
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        if (line.substring(i, i + 1).equals("C")) {
                            checkPoints.add(i);
                        }
                        if (line.substring(i, i + 1).equals("_")) {
                            gates.add(i);
                        }
                    }
                    if (!checkPoints.isEmpty()) {
                        if (checkPoints.get(0) == route) {
                            System.out.println(line.replace("C", "|"));
                            route = checkPoints.remove(0);
                        } else if (checkPoints.get(0) == (route - 1)) {
                            System.out.println(line.replace("C", "/"));
                            route = checkPoints.remove(0);
                        } else if (checkPoints.get(0) == (route + 1)) {
                            System.out.println(line.replace("C", "\\"));
                            route = checkPoints.remove(0);
                        }
                    } else {
                        if (gates.get(0) == route) {
                            System.out.println(line.replace("_", "|"));
                            route = gates.remove(0);
                        } else if (gates.get(0) == (route - 1)) {
                            System.out.println(line.replace("_", "/"));
                            route = gates.remove(0);
                        } else if (gates.get(0) == (route + 1)) {
                            System.out.println(line.replace("_", "\\"));
                            route = gates.remove(0);
                        }
                    }
                    checkPoints.clear();
                    gates.clear();
                }
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
