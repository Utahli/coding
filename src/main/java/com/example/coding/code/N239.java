package com.example.coding.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author utah
 * @desc
 * @date 2021/5/28 8:44 上午
 */
public class N239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        Deque<Integer> window = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }

            window.offerLast(i);
            if (i >= k - 1) {
                res.add(nums[window.peekFirst()]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        N239 n239 = new N239();
        System.out.println(n239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
