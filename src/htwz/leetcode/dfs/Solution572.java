package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 572. 另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * @author wangyu
 * @since 2023/2/10 23:09
 */
public class Solution572 {

  public static void main(String[] args) {

  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }
    return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean dfs(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null || subRoot == null || root.val != subRoot.val) {
      return false;
    }
    return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
  }

}
