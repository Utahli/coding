package com.example.coding.code;

import java.util.Arrays;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/9 上午9:41
 */
public class N6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int index = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            arr[index] += String.valueOf(c);

            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }

            index += flag;
        }

        StringBuilder ret = new StringBuilder();
        for (String s1 : arr) {
            ret.append(s1);
        }

        return ret.toString();
    }
}
