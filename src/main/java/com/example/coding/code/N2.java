package com.example.coding.code;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/15 上午9:07
 */
public class N2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode head = ret;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + temp;
            temp = sum / 10;
            sum = sum % 10;

            head.next = new ListNode(sum);
            head = head.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (temp == 1) {
            head.next = new ListNode(temp);
        }

        return ret.next;
    }
}
