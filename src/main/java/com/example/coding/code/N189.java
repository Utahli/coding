package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/25 下午11:38
 */
public class N189 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        int length = nums.length;
        int count = 0;
        for (int start = 0; count < length; start++) {
            int current = start;
            int pre = nums[current];
            do {
                int next = (current + k) % length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        int[] temp = new int[nums.length];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, length);
    }

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int start,int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
