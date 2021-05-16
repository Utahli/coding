package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc LC 17
 * @date 2021/5/5 5:11 下午
 */
public class LetterCombinations {

    public static Map<Character, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    List<String> res = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        this.digits = digits;
        StringBuilder path = new StringBuilder();
        backTrack(0, path);

        return res;
    }

    private void backTrack(int idx, StringBuilder path) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backTrack(idx + 1, path);
            path.deleteCharAt(idx);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(strings);
    }
}
