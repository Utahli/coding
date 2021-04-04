package com.example.coding.code;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/10 下午7:09
 */
public class N23 {

    N21 n21 = new N21();

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length;

        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = n21.mergeTwoLists(lists[i], lists[i + 1]);
                }
            }

            k = idx;
        }

        return lists[0];
    }

    public ListNode mergeKLists5(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return n21.mergeTwoLists(l1, l2);
    }

    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }

        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (true) {
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) {
                break;
            }

            tail.next = minNode;
            tail = tail.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int[] memo = new int[lists.length];

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                memo[i] = -1;
            }
        }

        ListNode ret = new ListNode();
        ListNode pre = ret;
        int firs = check(memo);
        while (firs != -1) {
            ListNode min = lists[firs];
            int minIndex = firs;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null && node.val < min.val) {
                    min = lists[i];
                    minIndex = i;
                }
            }

            pre.next = min;
            pre = pre.next;
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] == null) {
                memo[minIndex] = -1;
            }

            firs = check(memo);
        }

        return ret.next;
    }

    int check(int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != -1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        N23 n23 = new N23();
        ListNode listNode = n23.mergeKLists(lists);
        System.out.println(listNode);
    }
}
