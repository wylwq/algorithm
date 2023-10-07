package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author wangyu
 * @since 2023/2/10 23:21
 */
public class Solution938 {

  public static void main(String[] args) {

  }

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    if (root.val > high) {
      return rangeSumBST(root.left, low, high);
    }
    if (root.val < low) {
      return rangeSumBST(root.right, low, high);
    }
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
  }

}
