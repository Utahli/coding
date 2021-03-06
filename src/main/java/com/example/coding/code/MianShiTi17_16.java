package com.example.coding.code;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/24 下午10:16
 */
public class MianShiTi17_16 {
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }
}
