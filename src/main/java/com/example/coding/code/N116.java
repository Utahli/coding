package com.example.coding.code;;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2020/12/13 下午10:49
 */
public class N116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        // 将树左对齐，利用next指针逐层遍历，给处理下层节点
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node leftMost = root;
            while (leftMost.left != null) {
                Node head = leftMost;

                // 逐层遍历
                while (head != null) {
                    head.left.next = head.right;

                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }

                    // 指针向后移动
                    head = head.next;
                }

                // 遍历下层节点
                leftMost = leftMost.left;
            }

            return root;
        }

        //        层次遍历
        public Node connect2(Node root) {
            if (root == null) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                // 记录当前层的节点数
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();

                    if (i < size - 1) {
                        node.next = queue.peek();
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return root;
        }


        //        递归
        public Node connect1(Node root) {
            if (root == null) {
                return null;
            }

            connectTwoNode(root.left, root.right);
            return root;
        }

        public void connectTwoNode(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }

            if (node1.next != null) {
                return;
            }

            node1.next = node2;

            connectTwoNode(node1.left, node1.right);
            connectTwoNode(node2.left, node2.right);
            connectTwoNode(node1.right, node2.left);
        }
    }
}
