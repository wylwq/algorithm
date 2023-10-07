package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * @author wangyu
 * @since 2023/1/29 17:21
 */
public class Solution110 {

  public static void main(String[] args) {

  }

  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }

}