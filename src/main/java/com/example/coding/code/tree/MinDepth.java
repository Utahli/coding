package com.example.coding.code.tree;

import com.example.coding.code.TreeNode;

/**
 * @author utah
 * @desc
 * @date 2021/4/26 8:52 上午
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }

        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        if (root.left == null || root.right == null) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }
}
