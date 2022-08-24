package htwz.leetcode.bsearch;

import htwz.leetcode.bfs.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * @author wangyu
 * @since 2022/8/24 23:59
 */
public class Solution57 {

  public static void main(String[] args) {

  }

  private int ans = 0, count = 0;

  public int kthLargest(TreeNode root, int k) {
    helper(root, k);
    return ans;
  }

  private void helper(TreeNode root, int k) {
    if (root.right != null) {
      helper(root.right, k);
    }
    if (++count == k) {
      ans = root.val;
    }
    if (root.left != null) {
      helper(root.left, k);
    }
  }

}
