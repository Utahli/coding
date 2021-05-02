package com.example.coding.code.tree;

import com.example.coding.code.TreeNode;

/**
 * @author utah
 * @desc
 * @date 2021/4/25 10:33 下午
 */
public class N112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }
}