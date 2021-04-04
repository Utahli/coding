package com.example.coding.code;;

/**
 * @Author: LQT
 * @DateTime: 2021/2/12
 */
public class N125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (!checkChar(chars[l])) {
                l++;
                continue;
            }

            if (!checkChar(chars[r])) {
                r--;
                continue;
            }

            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    boolean checkChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }

        return c >= 'a' && c <= 'z';
    }


    public boolean isPalindrome1(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
