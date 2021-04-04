package com.example.coding.code;;

/**
 * @Author: LQT
 * @DateTime: 2021/2/8
 */
public class N387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i == arr[s.charAt(i) - 'a']) {
                return i;
            } else {
                arr[s.charAt(i) - 'a'] = -1;
            }
        }

        return -1;
    }
}
