package com.example.coding.code;;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/17 下午11:34
 */
public class N72 {
    public int minDistance(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();

        int[][] dp = new int[s1 + 1][s2 + 1];

        for (int i = 0; i <= s1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= s2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i-1][j-1]到dp[i][j]需要进行替换操作，
                    //dp[i-1][j]到d[i][j]需要进行删除操作
                    //dp[i][j-1] 到d[i][j]需要进行添加操作
                    dp[i][j] = min(dp[i - 1][j - 1] + 1,
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[s1][s2];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int minDistance2(String word1, String word2) {
        return dp(word1.toCharArray(), word1.length() - 1, word2.toCharArray(), word2.length() - 1);
    }

    Map<String, Integer> memo = new HashMap<>();

    int dp(char[] word1, int i, char[] word2, int j) {
        if (memo.containsKey(i + "," + j)) {
            return memo.get(i + "," + j);
        }

        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (word1[i] == word2[j]) {
            return dp(word1, i - 1, word2, j - 1);
        } else {
            int del = dp(word1, i - 1, word2, j) + 1;
            int ins = dp(word1, i, word2, j - 1) + 1;
            int rep = dp(word1, i - 1, word2, j - 1) + 1;
            int min = del;
            min = Math.min(min, ins);
            min = Math.min(min, rep);
            return min;
        }
    }
}
