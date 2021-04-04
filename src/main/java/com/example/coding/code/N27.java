package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/27 下午4:28
 */
public class N27 {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[length - 1];
                length--;
            }
        }

        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
