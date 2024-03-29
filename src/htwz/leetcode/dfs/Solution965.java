package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 965. 单值二叉树
 *
 * @author wangyu
 * @since 2023/2/11 12:48
 */
public class Solution965 {

  public static void main(String[] args) {

  }

  public boolean isUnivalTree(TreeNode root) {
    return dfs(root, root.val);
  }

  private boolean dfs(TreeNode root, int val) {
    if (root == null) {
      return true;
    }
    if (root.val != val) {
      return false;
    }
    return dfs(root.left, val) && dfs(root.right, val);
  }

}
