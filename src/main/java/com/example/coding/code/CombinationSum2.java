package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc LC 40
 * @date 2021/5/3 4:35 下午
 */
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        Deque<Integer> path = new LinkedList<>();
        backTrack(candidates, 0, path, target);

        return res;
    }

    private void backTrack(int[] candidates, int idx, Deque<Integer> path, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }

            // 同一层相同target、相同数值的节点，第i+1、i+2次的结果是第i次的子集
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.offerLast(candidates[i]);
            backTrack(candidates, i + 1, path, target - candidates[i]);
            path.pollLast();
        }
    }

}
