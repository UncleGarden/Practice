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
public class PrimePalindrome {

    public static void main(String[] args) {
        for (int i = 1000; i > 0; i--) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPalindrome(int num) {

        boolean flag = true;

        int temp = num;
        int num2 = 0;
        //反转得到数字
        while (temp != 0) {
            num2 = num2 * 10 + temp % 10;
            temp = temp / 10;
        }
        //如果一样，就是回文
        if (num == num2) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }

    public static boolean isPrime(int num) {

        boolean flag = true;
        //质数从2开始
        if (num < 2) {
            return false;
        } else {
            //根据质数的概念，需要循环到需要判断的数的平方根，因为此数字的最小公因子小于等于该数的平方根
            for (int i = 2; i <= Math.sqrt(num); i++) {
                //如果可以整除，就不是质数
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
