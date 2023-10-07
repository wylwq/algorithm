package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author wangyu
 * @since 2023/1/17 22:08
 */
public class Solution27 {

  public static void main(String[] args) {

  }

  public TreeNode mirrorTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = mirrorTree(root.left);
    TreeNode right = mirrorTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

}
