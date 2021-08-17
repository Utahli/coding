package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/5/29 6:37 下午
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }

        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2, 3));
    }
}
