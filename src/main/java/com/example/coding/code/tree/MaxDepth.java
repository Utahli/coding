package com.example.coding.code.tree;

import com.example.coding.code.TreeNode;

/**
 * @author utah
 * @desc
 * @date 2021/4/18 6:57 下午
 */
public class MaxDepth {
    int answer = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDepth(root, 1);
        return answer;
    }

    /**
     * 自顶向下
     */
    public void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }

        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }

}
