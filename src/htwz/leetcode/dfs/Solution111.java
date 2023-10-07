package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author wangyu
 * @since 2023/1/20 11:48
 */
public class Solution111 {

  public static void main(String[] args) {

  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    if (root.left != null) {
      min = Math.min(minDepth(root.left), min);
    }
    if (root.right != null) {
      min = Math.min(minDepth(root.right), min);
    }
    return min + 1;
  }

}