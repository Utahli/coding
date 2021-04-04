package com.example.coding.code;;

import java.util.Arrays;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/21 下午11:49
 */
public class N416 {

    public static void main(String[] args) {
        N416 n416 = new N416();
        int[] nums = new int[]{2, 2, 3, 5};
        System.out.println(n416.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            for (int w = 1; w <= sum; w++) {
                if (w - nums[i] < 0) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] | dp[i - 1][w - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }
}
