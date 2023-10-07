package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author wangyu
 * @since 2023/1/17 21:41
 */
public class Solution101 {

  public static void main(String[] args) {

  }

  public boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }

  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }

}