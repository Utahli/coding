package com.example.coding.code;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/10 上午11:28
 */
public class N19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        ListNode f = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }

        ListNode d = new ListNode(0, head);
        ListNode t = d;
        while (f != null) {
            f = f.next;
            t = t.next;
        }

        t.next = t.next.next;

        return d.next;
    }
}
