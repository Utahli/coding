package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc LC 46
 * @date 2021/4/28 11:17 下午
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }

        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        backTrack(nums, path, used);

        return res;
    }

    private void backTrack(int[] nums, Deque<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.offerLast(nums[i]);
            used[i] = true;
            backTrack(nums, path, used);
            path.pollLast();
            used[i] = false;
        }
    }
}
