package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author wangyu
 * @since 2023/3/5 22:19
 */
public class Solution783 {

  public static void main(String[] args) {

  }

  private int pre = -1;

  private int ans = Integer.MAX_VALUE;

  public int minDiffInBST(TreeNode root) {
    dfs(root);
    return ans;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (pre == -1) {
      pre = root.val;
    } else {
      ans = Math.min(ans, root.val - pre);
      pre = root.val;
    }
    dfs(root.right);
  }

}
