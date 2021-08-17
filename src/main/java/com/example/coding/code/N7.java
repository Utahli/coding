package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/5/27 11:16 下午
 */
public class N7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int res = 0;
        while (x != 0) {
            int digit = x % 10;

            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10) {
                return 0;
            }

            res = res * 10 + digit;
            x = x / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        N7 n7 = new N7();
        System.out.println(n7.reverse(-12345678));
    }
}
