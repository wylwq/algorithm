package htwz.leetcode.linked;

/**
 * 剑指 Offer II 024. 反转链表
 *
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 * @author wangyu
 * @since 2022/5/12 22:01
 */
public class Solution024 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
