package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/17 下午3:53
 */
public class N53 {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int ret = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }
}
