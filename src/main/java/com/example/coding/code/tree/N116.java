package com.example.coding.code.tree;;

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

        public Node connect3(Node root) {
            if (root == null) {
                return root;
            }
            //cur我们可以把它看做是每一层的链表
            Node cur = root;
            while (cur != null) {
                //遍历当前层的时候，为了方便操作在下一
                //层前面添加一个哑结点（注意这里是访问
                //当前层的节点，然后把下一层的节点串起来）
                Node dummy = new Node(0);
                //pre表示下一层节点的前一个节点
                Node pre = dummy;

                //然后开始遍历当前层的链表
                //因为是完美二叉树，如果有左子节点就一定有右子节点
                while (cur != null && cur.left != null) {
                    //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;

                    //pre节点的next指向当前节点的右子节点，
                    pre.next = cur.right;
                    pre = pre.next;
                    //继续访问这一行的下一个节点
                    cur = cur.next;
                }
                //把下一层串联成一个链表之后，让他赋值给cur，
                //后续继续循环，直到cur为空为止
                cur = dummy.next;
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
