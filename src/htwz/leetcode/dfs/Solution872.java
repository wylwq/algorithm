package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * @author wangyu
 * @since 2023/1/29 21:26
 */
class Solution872 {

  public static void main(String[] args) {

  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> seq1 = new ArrayList<>();
    dfs(root1, seq1);

    List<Integer> seq2 = new ArrayList<>();
    dfs(root2, seq2);

    return seq1.equals(seq2);
  }

  public void dfs(TreeNode node, List<Integer> seq) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      seq.add(node.val);
      return;
    }
    dfs(node.left, seq);
    dfs(node.right, seq);
  }
}
