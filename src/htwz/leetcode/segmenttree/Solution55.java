package htwz.leetcode.segmenttree;

import htwz.leetcode.bfs.TreeNode;

/**
 * @author wangyu
 * @since 2022/9/24 23:59
 */
public class Solution55 {

  public static void main(String[] args) {

  }

  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

}
