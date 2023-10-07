package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 *
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author wangyu
 * @since 2023/1/29 21:50
 */
public class Solution897 {

  public static void main(String[] args) {

  }

  public TreeNode increasingBST(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorder(root, ans);
    TreeNode dummyNode = new TreeNode(-1);
    TreeNode currNode = dummyNode;
    for (Integer val : ans) {
      currNode.right = new TreeNode(val);
      currNode = currNode.right;
    }
    return dummyNode.right;
  }

  private void inorder(TreeNode root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    inorder(root.left, ans);
    ans.add(root.val);
    inorder(root.right, ans);
  }

}