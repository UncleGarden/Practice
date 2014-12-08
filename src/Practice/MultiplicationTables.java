/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author Garden
 */
public class MultiplicationTables {

    public static void main(String[] args) {

        String[] matrix = new String[12];

        for (int i = 1; i <= 12; i++) {
            if (i == 1) {
                matrix[i - 1] = String.valueOf(i);
            } else {
                matrix[i - 1] = String.valueOf(i);
            }
        }

        int times = 1;
        while (times <= 12) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    System.out.print(Integer.valueOf(matrix[j]) * times);
                } 
//                //p.s. AFTER 9, the first number will be 10, 2 digits. 
//                else if (Integer.valueOf(matrix[j]) * times > 18 && j == 1) {
//                    System.out.print(" " + Integer.valueOf(matrix[j]) * times);
//                } 
                else {
                    for (int k = 0; k < 4 - String.valueOf(Integer.valueOf(matrix[j]) * times).length(); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(Integer.valueOf(matrix[j]) * times);
                }
            }
            times++;
            System.out.println();
        }
    }
}
