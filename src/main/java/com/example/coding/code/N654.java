package com.example.coding.code;;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/14 下午10:41
 */
public class N654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }


        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);

        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
