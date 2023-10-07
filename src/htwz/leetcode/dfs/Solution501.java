package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @author wangyu
 * @since 2023/1/29 22:00
 */
public class Solution501 {

  private List<Integer> answer = new ArrayList<>();
  private int base, count, maxCount;

  public static void main(String[] args) {

  }

  public int[] findMode(TreeNode root) {
    dfs(root);
    int[] mode = new int[answer.size()];
    for (int i = 0; i < answer.size(); i++) {
      mode[i] = answer.get(i);
    }
    return mode;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    update(root.val);
    dfs(root.right);
  }

  private void update(int val) {
    if (base == val) {
      count++;
    } else {
      count = 1;
      base = val;
    }
    if (count == maxCount) {
      answer.add(base);
    }
    if (count > maxCount) {
      maxCount = count;
      answer.clear();
      answer.add(base);
    }
  }

}
