package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @author wangyu
 * @since 2023/1/20 18:28
 */
public class Solution257 {

  public static void main(String[] args) {

  }
  private List<String> ans = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    dfs(root, "");
    return ans;
  }

  private void dfs(TreeNode root, String path) {
    if (root != null) {
      StringBuilder paths = new StringBuilder(path);
      paths.append(root.val);
      if (root.left == null && root.right == null) {
        ans.add(paths.toString());
      } else {
        paths.append("->");
        dfs(root.left, paths.toString());
        dfs(root.right, paths.toString());
      }
    }
  }
}
