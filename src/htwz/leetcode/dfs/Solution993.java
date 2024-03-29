package htwz.leetcode.dfs;

import htwz.leetcode.bfs.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * @author wangyu
 * @since 2023/1/29 21:07
 */
public class Solution993 {

  private int xDepth;
  private TreeNode xParent;
  private boolean xFound;
  private int x;

  private int yDepth;
  private TreeNode yParent;
  private boolean yFound;
  private int y;

  public static void main(String[] args) {

  }

  public boolean isCousins(TreeNode root, int x, int y) {
    this.x = x;
    this.y = y;
    dfs(root, 0, null);
    return xDepth == yDepth && xParent != yParent;
  }

  private void dfs(TreeNode root, int depth, TreeNode parent) {
    if (root == null) {
      return;
    }
    if (root.val == x) {
      xParent = parent;
      xDepth = depth;
      xFound = true;
    }
    if (root.val == y) {
      yParent = parent;
      yDepth = depth;
      yFound = true;
    }
    if (xFound && yFound) {
      return;
    }

    dfs(root.left, depth + 1, root);

    if (xFound && yFound) {
      return;
    }

    dfs(root.right, depth + 1, root);
  }

}
