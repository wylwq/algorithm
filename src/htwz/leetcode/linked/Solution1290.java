package htwz.leetcode.linked;

/**
 * 1290. 二进制链表转整数
 * 思路：链表反转，二进制转十进制
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * @author wangyu
 * @since 2022/5/12 22:04
 */
public class Solution1290 {

    public static void main(String[] args) {

    }

    public static int getDecimalValue(ListNode head) {
        int ans = 0, i = 1;
        ListNode node = reverse(head);
        while(node != null) {
            ans += node.val * i;
            node = node.next;
            i = i << 1;
        }
        return ans;
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
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
