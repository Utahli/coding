package com.example.coding.code.tree;

import com.example.coding.code.TreeNode;

import java.util.*;

/**
 * @author utah
 * @desc
 * @date 2021/6/6 3:44 下午
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean orderLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> currLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (orderLeft) {
                    currLevel.offerLast(curr.val);
                } else {
                    currLevel.offerFirst(curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(new LinkedList<>(currLevel));
            orderLeft = !orderLeft;
        }

        return res;
    }
}
