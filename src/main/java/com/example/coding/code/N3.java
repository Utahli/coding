package com.example.coding.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LQT
 * @DateTime: 2021/3/7
 */
public class N3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        int invalid = 0;
        while (r < s.length()) {
            if (window.getOrDefault(s.charAt(r), 0) > 0) {
                invalid++;
            }
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            r++;

            while (invalid > 0) {
                if (window.get(s.charAt(l)) > 1) {
                    invalid--;
                }
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                l++;
            }

            ans = Math.max(ans, r - l);
        }

        return ans;
    }

    public static void main(String[] args) {
        String a = "abba";
        N3 n3 = new N3();
        n3.lengthOfLongestSubstring(a);
    }
}
