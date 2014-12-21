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
public class StackImplementation {

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
                if (line.length() == 0) {
                    continue;
                }

                String[] array = line.split("\\s+");

                int[] list = new int[array.length];

                Stack<Integer> s = new Stack<>();

                for (int i = 0; i < list.length; i++) {
                    list[i] = Integer.valueOf(array[i]);
                    s.push(list[i]);
                }

                boolean status = true;

                while (!s.isEmpty()) {

                    int cur = s.pop();

                    if (status) {
                        System.out.print(cur);

                        if (s.size() >= 2) {
                            System.out.print(" ");
                        }
                    }

                    status = !status;
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }
}

//right case:

/**
 * public class StackImplementation {
    private static int[] storage;
    private static int size; 
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
	Scanner in = new Scanner(file);
	while(in.hasNextLine()) {
            storage = new int[10]; 
            Scanner lineScan = new Scanner(in.nextLine()); 
            while (lineScan.hasNextInt()) {
                int num = lineScan.nextInt(); 
                push(num); 
            }
                        
            int i = 0; 
            String result = ""; 
            int original = size; 
            while (i < original) {
                if (i % 2 == 0) {
                    result += pop() + " "; 
                } else {
                    pop(); 
                }
                i++; 
            }
            
            System.out.println(result.trim()); 
	}
    }
    
    public static int pop() {
        size--; 
        
        if (((double)size / storage.length) <= 0.25) {
		double[] temp = storage; 
		storage = new double[storage.length / 2]; 
		for (int i = 0; i < size; i++) {
			storage[i] = temp[i]; 
		}
	}		

        return storage[size]; 
    }
    
    public static void push(int num) {
        size++; 
        if (size > storage.length) {
            int[] temp = storage; 
            storage = new int[storage.length * 2]; 
            for (int i = 0; i < temp.length; i++) {
                storage[i] = temp[i];
            }
        }
        
        storage[size - 1] = num; 
    }
}
 * 
 */
