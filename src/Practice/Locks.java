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
public class Locks {

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

                String[] array = line.split("\\s+");

                int lockNum = Integer.valueOf(array[0]);
                int times = Integer.valueOf(array[1]);

                String[] locks = new String[lockNum];
                for (int i = 0; i < locks.length; i++) {
                    locks[i] = "O";
                }

                while (times > 1) {
                    locks = by2(locks);
//                    for (int i = 0; i < locks.length; i++) {
//                        System.out.print(locks[i] + ",");
//                    }
//                    System.out.println();
                    locks = by3(locks);
//                    for (int i = 0; i < locks.length; i++) {
//                        System.out.print(locks[i] + ",");
//                    }
                    times--;
//                    System.out.println();
                }

                if (locks[locks.length - 1] == "O") {
                    locks[locks.length - 1] = "T";
                } else {
                    locks[locks.length - 1] = "O";
                }

                int count = 0;

                for (int i = 0; i < locks.length; i++) {
                    //System.out.println(locks[i]);
                    if (locks[i] == "O") {
                        count++;
                    }
                }

                System.out.println(count);
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static String[] by2(String[] locks) {
        for (int i = 0; i < locks.length; i++) {
            if ((i + 1) % 2 == 0 && locks[i] == "O") {
                locks[i] = "L";
            }
        }
        return locks;
    }

    public static String[] by3(String[] locks) {
        for (int i = 0; i < locks.length; i++) {
            if ((i + 1) % 3 == 0) {
                if (locks[i] == "O") {
                    locks[i] = "L";
                } else {
                    locks[i] = "O";
                }
            }
        }
        return locks;
    }
}
