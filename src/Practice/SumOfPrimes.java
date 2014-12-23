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
public class SumOfPrimes {

    public static void main(String[] args) {

        int count = 1;
        int num = 1;
        int result = 0;

        while (count <= 1000) {
            if (isPrime(num)) {
                count++;
                result += num;
            }
            num++;
        }
        System.out.println(result);
    }

    public static Boolean isPrime(int num) {

        Boolean flag = true;

        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
