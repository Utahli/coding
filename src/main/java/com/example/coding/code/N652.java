package com.example.coding.code;;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/15 下午11:08
 */
public class N652 {
    public Map<String, Integer> memo = new HashMap<>();
    public List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = root.val + "," + left + "," + right;

        Integer freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }

        memo.put(subTree, freq + 1);

        return subTree;
    }
}
