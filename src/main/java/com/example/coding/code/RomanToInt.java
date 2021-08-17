package com.example.coding.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author utah
 * @desc
 * @date 2021/5/29 3:03 下午
 */
public class RomanToInt {

    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            default:
                return 0;
        }
    }

    public static final Map<Character, Integer> ROMAN_MAPPED = new HashMap<>();

    static {
        ROMAN_MAPPED.put('I', 1);
        ROMAN_MAPPED.put('V', 5);
        ROMAN_MAPPED.put('X', 10);
        ROMAN_MAPPED.put('L', 50);
        ROMAN_MAPPED.put('C', 100);
        ROMAN_MAPPED.put('D', 500);
        ROMAN_MAPPED.put('M', 1000);
    }

    public int romanToInt1(String s) {
        int r = s.length() - 1;
        int l = r - 1;

        Integer pre = ROMAN_MAPPED.get(s.charAt(r));
        int res = pre;
        while (l >= 0) {
            Integer cur = ROMAN_MAPPED.get(s.charAt(l));
            if (cur < pre) {
                res -= cur;
            } else {
                res += cur;
            }

            pre = cur;
            l--;
        }

        return res;
    }
}
