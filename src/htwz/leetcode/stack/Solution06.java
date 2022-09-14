package htwz.leetcode.stack;

import htwz.leetcode.linked.ListNode;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author wangyu
 * @since 2022/9/14 23:29
 */
public class Solution06 {

  public static void main(String[] args) {

  }

  public int[] reversePrint(ListNode head) {
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode temp = head;
    while (temp != null) {
      stack.push(temp);
      temp = temp.next;
    }
    int size = stack.size();
    int[] print = new int[size];
    for (int i = 0; i < size; i++) {
      print[i] = stack.pop().val;
    }
    return print;
  }

}
