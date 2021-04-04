package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/15 上午10:10
 */
public class N105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                               int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                index = i;
                break;
            }
        }

        int size = index - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + size,
                inOrder, inStart, index - 1);
        root.right = buildTree(preOrder, preStart + size + 1, preEnd,
                inOrder, index + 1, inEnd);

        return root;
    }
}
