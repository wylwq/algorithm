package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyu
 * @since 2023/1/29 21:40
 */
public class Solution637 {

  public static void main(String[] args) {

  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<Integer> counts = new ArrayList<>();
    List<Double> sums = new ArrayList<>();

    dfs(root, 0, counts, sums);

    List<Double> averages = new ArrayList<>();
    for (int i = 0; i < sums.size(); i++) {
      averages.add(sums.get(i) / counts.get(i));
    }
    return averages;
  }

  private void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
    if (root == null) {
      return;
    }
    if (sums.size() > level) {
      sums.set(level, sums.get(level) + root.val);
      counts.set(level, counts.get(level) +1);
    } else {
      sums.add(1.0 * root.val);
      counts.add(1);
    }
    dfs(root.left, level + 1, counts, sums);
    dfs(root.right, level + 1, counts, sums);
  }

}
