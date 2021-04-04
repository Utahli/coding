package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/20 下午8:42
 */
public class N538 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);

        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }
}
