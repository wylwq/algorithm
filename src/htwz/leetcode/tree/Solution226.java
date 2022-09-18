package htwz.leetcode.tree;

/**
 * 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author wangyu
 * @since 2022/9/18 23:29
 */
public class Solution226 {

  public static void main(String[] args) {

  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = left;
    return root;
  }

}
