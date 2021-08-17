package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/6/13 12:30 下午
 */
public class DeleteChar {
    /**
     * @param str: the string
     * @param k:   the length
     * @return: the substring with  the smallest lexicographic order
     */
    public String deleteChar(String str, int k) {
        if (str.length() == k) {
            return str;
        }
        if (str.length() < k) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (sb.length() < k) {
            char curr = str.charAt(start);
            int next = start;
            for (int i = start + 1; i <= str.length() - (k - sb.length()); i++) {
                if (str.charAt(i) < curr) {
                    curr = str.charAt(i);
                    next = i;
                }
            }

            sb.append(curr);
            start = next + 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DeleteChar deleteChar = new DeleteChar();
        System.out.println(deleteChar.deleteChar("fskaba", 3));
    }
}
