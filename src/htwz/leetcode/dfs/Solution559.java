package htwz.leetcode.dfs;

/**
 * 559. N 叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author wangyu
 * @since 2023/1/29 21:03
 */
public class Solution559 {

  public static void main(String[] args) {

  }

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int maxD = 0;
    for (Node child : root.children) {
      int childD = maxDepth(child);
      maxD = Math.max(maxD, childD);
    }
    return maxD + 1;
  }

}