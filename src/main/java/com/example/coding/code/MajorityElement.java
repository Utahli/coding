package com.example.coding.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author utah
 * @desc
 * @date 2021/5/29 9:47 下午
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int majorityNum = nums.length / 2;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > majorityNum) {
                res = entry.getKey();
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3,2,3}));
    }
}
