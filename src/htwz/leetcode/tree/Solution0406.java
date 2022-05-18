package htwz.leetcode.tree;

/**
 * 面试题 04.06. 后继者
 *
 * 思路：TBS(二叉搜索树)满足左子树的值小于根节点，根节点的值小于右子树
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * @author wangyu
 * @since 2022/5/19 0:14
 */
public class Solution0406 {

    public static void main(String[] args) {

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }

}
