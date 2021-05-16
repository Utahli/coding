package com.example.coding.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author utah
 * @desc
 * @date 2021/5/4 10:05 下午
 */
public class GetPermutation {

    int[] factorial;
    boolean[] used;
    int n;
    int k;

    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }

        factorial = calculateFactorial(n);
        used = new boolean[n + 1];
        this.n = n;
        this.k = k;

        StringBuilder res = new StringBuilder();
        dfs(0, res);

        return res.toString();
    }

    private void dfs(int idx, StringBuilder res) {
        if (idx == n) {
            return;
        }

        int cal = factorial[n - 1 - idx];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }

            // 当前节点下的全排列不满足条件，排序减掉不满足的排列数，接着到下一个节点的全排列查找
            if (cal < k) {
                k -= cal;
                continue;
            }

            // k<=cal, 结果在当前节点下的全排列中
            res.append(i);
            used[i] = true;
            dfs(idx + 1, res);
            // 结果在上面已经找到了，不需要再回溯
            return;
        }
    }

    private int[] calculateFactorial(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        return factorial;
    }


    String res = "";
    int count = 0;

    public String getPermutation2(int n, int k) {
        if (n == 0) {
            return "";
        }

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[n];
        count = k;

        backTrack2(nums, used, path);
        return res;
    }

    private void backTrack2(int[] nums, boolean[] used, Deque<Integer> path) {
        if (count == 0) {
            StringBuilder sb = new StringBuilder();
            while (path.size() > 0) {
                sb.append(path.pollFirst().toString());
            }
            res = sb.toString();
            count -= 1;
            return;
        }

        if (path.size() == nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!"".equals(res)) {
                return;
            }

            if (used[i]) {
                continue;
            }

            path.offerLast(nums[i]);
            used[i] = true;
            if (path.size() == nums.length) {
                count -= 1;
            }
            backTrack2(nums, used, path);
            path.pollLast();
            used[i] = false;
        }
    }
}
