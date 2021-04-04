package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/24 下午10:32
 */
public class N474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int[] count = count(str);

            for (int zero = m; zero >= count[0]; zero--) {
                for (int one = n; one >= count[1]; one --) {
                    dp[zero][one] = Math.max(1 + dp[zero - count[0]][one - count[1]], dp[zero][one]);
                }
            }
        }

        return dp[m][n];
    }

    int[] count(String str) {
        int[] res = new int[2];

        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0']++;
        }

        return res;
    }
}
