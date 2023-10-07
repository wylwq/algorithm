package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.Base64;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author wangyu
 * @since 2023/1/29 22:06
 */
public class Solution530 {

  private Integer pre;

  private int ans;

  public static void main(String[] args) {
    
  }

  public int getMinimumDifference(TreeNode root) {
    ans = Integer.MAX_VALUE;
    pre = -1;
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
