package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * @author wangyu
 * @since 2022/8/20 10:43
 */
public class Solution508 {

  public static void main(String[] args) {

  }

  private static int max = 0;

  public static int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    Map<Integer, Integer> map = new HashMap<>();
    dfs(root, map);
    List<Integer> res = new LinkedList<>();
    for (Integer key : map.keySet()) {
      if (map.get(key) == max) {
        res.add(key);
      }
    }
    int[] ans = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }

  private static int dfs(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left, map);
    int right = dfs(root.right, map);
    int val = left + right + root.val;
    map.put(val, map.getOrDefault(val, 0) + 1);
    max = Math.max(max, map.get(val));
    return val;
  }

}
