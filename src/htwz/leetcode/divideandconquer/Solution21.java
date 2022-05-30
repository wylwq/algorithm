package htwz.leetcode.divideandconquer;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author wangyu
 * @since 2022/5/30 15:14
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode prve = ans;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                prve.next = list1;
                list1 = list1.next;
            } else {
                prve.next = list2;
                list2 = list2.next;
            }
            prve = prve.next;
        }
        prve.next = list1 != null ? list1 : list2;
        return ans.next;
    }

    public static void main(String[] args) {

    }

}
