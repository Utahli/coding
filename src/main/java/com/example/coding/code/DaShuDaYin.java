package com.example.coding.code;

/**
 * @Author: LQT
 * @DateTime: 2021/2/12
 */
public class DaShuDaYin {
    public int[] printNumbers(int n) {
        int len = 0;
        while (n > 0) {
            len = len * 10 + 9;
            n--;
        }

        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }

        return res;
    }

    public int[] printNumbers1(int n) {
        int len = (int) Math.pow(10, n);

        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }

        return res;
    }
}
