package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/6/13 1:12 下午
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }
}
