package htwz.leetcode.binarytree;

import htwz.leetcode.bfs.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangyu
 * @since 2022/9/19 23:23
 */
public class Solution55 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode l1 = new TreeNode(1);
    TreeNode l2 = new TreeNode(1);
    l1.left = l2;
    root.left = l1;
    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftMaxDepth = maxDepth(root.left);
      int rightMaxDepth = maxDepth(root.right);
      return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
  }


  public int maxDepthV1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int ans = 0;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      while (size > 0) {
        TreeNode poll = q.poll();
        if (poll.left != null) {
          q.offer(poll.left);
        }
        if (poll.right != null) {
          q.offer(poll.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
  }

}
