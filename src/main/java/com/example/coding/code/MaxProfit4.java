package com.example.coding.code;

import java.util.Arrays;

/**
 * @author utah
 * @desc
 * @date 2021/6/5 3:27 下午
 */
public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        k = Math.min(k, prices.length / 2);

        int[][][] dp = new int[prices.length][k + 1][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < k + 1; i++) {
            dp[0][i][0] = Integer.MIN_VALUE/2;
            dp[0][i][1] = Integer.MIN_VALUE/2;
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < k + 1; i++) {
            maxProfit = Math.max(maxProfit, dp[prices.length - 1][i][0]);
        }
        return maxProfit;
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        MaxProfit4 maxProfit4 = new MaxProfit4();
        int maxProfit = maxProfit4.maxProfit(1, new int[]{2, 1});
        System.out.println(maxProfit);
    }
}
