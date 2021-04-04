package com.example.coding.code;;

import java.util.Arrays;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/17 下午9:58
 */
public class N300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ret = 1;
        for (int i = 0; i < dp.length; i++) {
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }
}
