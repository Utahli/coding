package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/24 下午8:44
 */
public class N518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    dp[j] += dp[j - coin];
                }
            }
        }

        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int length = coins.length;

        int[][] dp = new int[length + 1][amount + 1];

        for (int i = 0; i <= length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[length][amount];
    }
}
