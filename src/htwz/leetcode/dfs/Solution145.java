package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * @author wangyu
 * @since 2023/1/20 18:42
 */
public class Solution145 {

  public static void main(String[] args) {

  }

  private List<Integer> ans = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    dfs(root);
    return ans;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    dfs(root.right);
    ans.add(root.val);
  }

}
