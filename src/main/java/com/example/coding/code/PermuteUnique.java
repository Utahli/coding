package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc LC 47
 * @date 2021/5/1 11:39 上午
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        backTrack(nums, used, path);

        return res;
    }

    private void backTrack(int[] nums, boolean[] used, Deque<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            //当前值等于前一个值： 两种情况：
            //1 nums[i-1] 没用过 说明回溯到了同一层 此时接着用num[i] 则会与 同层用num[i-1] 重复
            //2 nums[i-1] 用过了 说明此时在num[i-1]的下一层 相等不会重复
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.offerLast(nums[i]);
            used[i] = true;
            backTrack(nums, used, path);
            path.pollLast();
            used[i] = false;
        }
    }
}
