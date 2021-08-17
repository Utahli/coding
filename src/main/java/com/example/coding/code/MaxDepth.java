package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/6/6 3:01 下午
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return _dfs(root, 0);
    }

    private int _dfs(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int left = _dfs(root.left, level);
        int right = _dfs(root.right, level);

        return 1 + Math.max(left, right);
    }
}
