package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入二叉搜索树
 *
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * @author wangyu
 * @since 2023/2/11 13:16
 */
public class Solution653 {

  public static void main(String[] args) {

  }

  private Set<Integer> set = new HashSet<>();

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
