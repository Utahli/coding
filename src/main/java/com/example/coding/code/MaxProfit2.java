package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/6/5 3:27 下午
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }
}
