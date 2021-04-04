package com.example.coding.code;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/21 下午11:06
 */
public class Knapsack {
    /**
     * @param weight   物品重量数组
     * @param money    物品价值数组
     * @param capacity 背包容量
     * @return 背包可以装物品的最大价值
     */
    public int knapsackLoadItemMaxValue(int[] weight, int[] money, int capacity) {
        if (capacity == 0 || weight == null || weight.length == 0) {
            return 0;
        }

        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j - weight[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], money[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }

        return dp[weight.length][capacity];
    }
}
