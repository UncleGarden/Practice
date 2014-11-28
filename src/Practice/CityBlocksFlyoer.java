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
public class CityBlocksFlyoer {

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
        ArrayList<Double> leftTop = new ArrayList<>();
        ArrayList<Double> rightBottom = new ArrayList<>();

        try {
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split("\\s+");

                String[] streets = array[0].substring(1, array[0].length() - 1).split(",");
                String[] avenues = array[1].substring(1, array[1].length() - 1).split(",");

                double t = 0;
                double b = 0;
                for (int i = 1; i < streets.length; i++) {
                    for (int j = 0; j < avenues.length - 1; j++) {
                        t = Double.valueOf(avenues[j]) / Double.valueOf(streets[i]);
                        //System.out.print("t:" + t);
                        rightBottom.add(t);
                        if (streets[i - 1].equals("0")) {
                            b = Double.MAX_VALUE;
                        } else {
                            b = Double.valueOf(avenues[j + 1]) / Double.valueOf(streets[i - 1]);
                        }
                        leftTop.add(b);
                        //System.out.print("b:" + b);
                    }
                }

                double slope = Double.valueOf(avenues[avenues.length - 1]) / Double.valueOf(streets[streets.length - 1]);

                int block = 0;
                for (int k = 0; k < leftTop.size(); k++) {
                    if (leftTop.get(k) > slope && rightBottom.get(k) < slope) {
                        block++;
                    }
                }

                System.out.println(block);
                leftTop.clear();
                rightBottom.clear();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}
