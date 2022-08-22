package htwz.leetcode.tree;

/**
 * 1367. 二叉树中的列表
 *
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
 * 那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 * @author wangyu
 * @since 2022/8/22 23:33
 */
public class Solution1367 {

  public static void main(String[] args) {

  }

  public boolean isSubPath(ListNode head, TreeNode root) {
    if (check(head, root)) {
      return true;
    }
    if (root == null) {
      return false;
    }
    return isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  public boolean check(ListNode head, TreeNode root) {
    if (root == null) {
      return head == null;
    }
    if (head == null) {
      return true;
    }
    if (root.val != head.val) {
      return false;
    }
    return check(head.next, root.left) || check(head.next, root.right);
  }

}