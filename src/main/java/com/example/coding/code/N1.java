package com.example.coding.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/28 下午11:30
 */
public class N1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return ret;
    }
}
