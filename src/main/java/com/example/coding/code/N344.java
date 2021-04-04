package com.example.coding.code;;

/**
 * @Author: LQT
 * @DateTime: 2021/2/5
 */
public class N344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}
