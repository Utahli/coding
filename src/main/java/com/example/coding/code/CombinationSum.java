package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc LC 39
 * @date 2021/4/28 10:19 下午
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, 0, target);
        return res;
    }

    void backTrack(int[] candidates, int idx, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.offerLast(candidates[i]);
            backTrack(candidates, i, target - candidates[i]);
            path.pollLast();
        }
    }
}
