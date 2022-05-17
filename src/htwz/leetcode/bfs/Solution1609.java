package htwz.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. 奇偶树
 *
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 * @author wangyu
 * @since 2022/5/17 22:48
 */
public class Solution1609 {

    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int prev = flag ? 0 : 99999999;
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                int val = node.val;
                if (flag && (val % 2 == 0 || val <= prev)) {
                    return false;
                }
                if (!flag && (val % 2 != 0 || val >= prev)) {
                    return false;
                }
                prev = val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            flag = !flag;
        }
        return true;
    }
}
