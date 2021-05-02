package com.example.coding.code.tree;

import com.example.coding.code.TreeNode;

import java.util.*;

/**
 * @author utah
 * @desc LC：113
 * @date 2021/4/26 10:16 下午
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }


    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        Deque<Integer> track = new LinkedList<>();
        track.offerLast(root.val);
        backTrack(root, targetSum - root.val, track);
        return res;
    }

    private void backTrack(TreeNode root, int targetSum, Deque<Integer> track) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(Arrays.asList(track.toArray(track.toArray(new Integer[0]))));
                return;
            }
        }

        if (root.left != null) {
            track.offerLast(root.left.val);
            backTrack(root.left, targetSum - root.left.val, track);
            track.pollLast();
        }

        if (root.right != null) {
            track.offerLast(root.right.val);
            backTrack(root.right, targetSum - root.right.val, track);
            track.pollLast();
        }
    }
}
