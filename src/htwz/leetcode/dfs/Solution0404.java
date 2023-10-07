package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 *
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 * @author wangyu
 * @since 2023/1/17 21:45
 */
public class Solution0404 {

  public static void main(String[] args) {

  }

  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftH = height(root.left);
    int rightH = height(root.right);
    if (leftH == -1 || rightH == -1 || (Math.abs(leftH - rightH) > 1)) {
      return -1;
    }
    return Math.max(leftH, rightH) + 1;
  }

}
