package com.example.coding.code.tree;

/**
 * @author utah
 * @desc
 * @date 2021/4/20 8:12 上午
 */
public class Connect2 {
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
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;
        while (cur != null) {
            Node dumb = new Node(0);
            Node pre = dumb;

            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next;
            }

            cur = dumb.next;
        }

        return root;
    }


    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        connect2(root.left);
        connect2(root.right);

        return root;
    }

    private Node getNext(Node uncle) {
        if (uncle == null) {
            return null;
        } else if (uncle.left != null) {
            return uncle.left;
        } else if (uncle.right != null) {
            return uncle.right;
        } else {
            return getNext(uncle.next);
        }
    }
}
