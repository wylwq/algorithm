package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 *
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
 * 假设二叉搜索树中节点的值均唯一。
 *
 * @author wangyu
 * @since 2023/1/17 22:21
 */
public class Solution56 {

  private Set<Integer> set = new HashSet<>();

  public static void main(String[] args) {
  }

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    if (set.contains(k - root.val)) {
      return true;
    }
    set.add(root.val);
    return findTarget(root.left, k) || findTarget(root.right, k);
  }

}
