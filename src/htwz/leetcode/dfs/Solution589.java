package htwz.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 *
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author wangyu
 * @since 2023/1/29 20:32
 */
public class Solution589 {

  public static void main(String[] args) {

  }

  public List<Integer> preorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, ans);
    return ans;
  }

  private void dfs(Node root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    ans.add(root.val);
    for (Node child : root.children) {
      dfs(child, ans);
    }
  }


}
