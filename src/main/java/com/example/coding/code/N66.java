package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/27 下午4:41
 */
public class N66 {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;

            digits[i] %= 10;

            if (digits[i] > 0) {
                return digits;
            }
        }

        int[] ret = new int[digits.length + 1];
        ret[0] = 1;

        return ret;
    }

    public int[] plusOne1(int[] digits) {
        digits[digits.length - 1]++;

        int addon = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += addon;

            addon = 0;
            if (digits[i] >= 10) {
                addon = 1;
                digits[i] %= 10;
            }
        }

        if (addon > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = addon;
            System.arraycopy(digits, 0, ret, 1, digits.length);

            return ret;
        }

        return digits;
    }

}
