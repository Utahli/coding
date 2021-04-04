package com.example.coding.code;;

/**
 * @Author: LQT
 * @DateTime: 2021/2/13
 */
public class N58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int lastWordLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lastWordLen == 0) {
                    continue;
                }
                return lastWordLen;
            }

            lastWordLen++;
        }

        return lastWordLen;
    }
}
