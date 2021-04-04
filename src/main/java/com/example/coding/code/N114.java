package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/14 下午9:52
 */
public class N114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 后序遍历
        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;

        root.right = root.left;
        root.left = null;

        // 移动指针到最右节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
