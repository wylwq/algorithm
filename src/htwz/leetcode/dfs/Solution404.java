package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 404. 左叶子之和
 *
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @author wangyu
 * @since 2023/1/20 18:36
 */
public class Solution404 {

  public static void main(String[] args) {

  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null && root.left.left == null && root.left.right == null) {
      sum += root.left.val;
    }
    return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }

}
