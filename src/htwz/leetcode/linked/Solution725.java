package htwz.leetcode.linked;

/**
 * 725. 分隔链表
 *
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 * @author wangyu
 * @since 2022/8/14 12:34
 */
public class Solution725 {

  public static void main(String[] args) {
    int k = 5;
    ListNode l3 = new ListNode();
    l3.setVal(3);
    ListNode l2 = new ListNode();
    l2.setVal(2);
    l2.setNext(l3);
    ListNode l1 = new ListNode();
    l1.setVal(1);
    l1.setNext(l2);
    ListNode[] listNodes = splitListToParts(l1, 1);
    for (ListNode listNode : listNodes) {
      while (listNode != null) {
        System.out.printf("%d\t", listNode.val);
        listNode = listNode.next;
      }
      System.out.println();
    }
  }

  public static ListNode[] splitListToParts(ListNode head, int k) {
    int len = 0;
    ListNode tmp = head;
    while (tmp != null) {
      tmp = tmp.next;
      len++;
    }
    int per = len / k;
    int rem = len % k;
    ListNode[] ans = new ListNode[k];
    for (int i = 0; i < rem; i++) {
      ans[i] = head;
      tmp = ans[i];
      int c = per + 1;
      while (c-- > 1) {
        tmp = tmp.next;
      }
      head = tmp != null ? tmp.next : null;
      if (tmp != null) {
        tmp.next = null;
      }
    }
    for (int i = 0; i < k - rem; i++) {
      ans[i + rem] = head;
      tmp = ans[i + rem];
      int c = per;
      while (c-- > 1) {
        tmp = tmp.next;
      }
      head = tmp != null ? tmp.next : null;
      if (tmp != null) {
        tmp.next = null;
      }
    }
    return ans;
  }

}