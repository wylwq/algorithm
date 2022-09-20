package htwz.leetcode.bsttree;

import htwz.leetcode.bfs.TreeNode;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 *
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 *
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 * @author wangyu
 * @since 2022/9/21 0:10
 */
public class Solution53 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(3);
    root.left = left;
    root.right = right;
    TreeNode p = new TreeNode(1);
    System.out.println(inorderSuccessor(root, p));
  }

  static TreeNode ans;
  public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    dfs(root,p);
    return ans;
  }
  public static void dfs(TreeNode root,TreeNode p){
    if (root == null) {
      return;
    }
    dfs(root.left, p);
    if (ans == null && root.val > p.val) {
      ans = root;
      return;
    }
    dfs(root.right, p);
  }


}
