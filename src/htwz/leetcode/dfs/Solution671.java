package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * @author wangyu
 * @since 2023/1/29 21:30
 */
public class Solution671 {

  private int rootVal;
  private int ans;

  public static void main(String[] args) {

  }

  public int findSecondMinimumValue(TreeNode root) {
    ans = -1;
    rootVal = root.val;
    dfs(root);
    return ans;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    if (ans != -1 && root.val >= ans) {
      return;
    }
    if (root.val > rootVal) {
      ans = root.val;
    }
    dfs(root.left);
    dfs(root.right);
  }

}
