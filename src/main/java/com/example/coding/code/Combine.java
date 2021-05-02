package com.example.coding.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author utah
 * @desc LC 77
 * @date 2021/4/28 10:56 下午
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }

        int[] selection = new int[n];
        for (int i = 0; i < n; i++) {
            selection[i] = i + 1;
        }

        backTrack(selection, 0, k);
        return res;
    }

    void backTrack(int[] selection, int idx, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < selection.length - (k - path.size()) + 1; i++) {
            path.offerLast(selection[i]);
            backTrack(selection, i + 1, k);
            path.pollLast();
        }
    }
}
