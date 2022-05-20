package htwz.leetcode.bsttree;

import htwz.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 *
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * @author wangyu
 * @since 2022/5/20 8:11
 */
public class Solution1382 {

    public static void main(String[] args) {

    }

    List<Integer> bst = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        midOrder(root);
        System.out.println(bst);
        return cur(0, bst.size() - 1, bst);
    }

    private void midOrder(TreeNode root) {
        if(root == null) {

            return;
        }
        midOrder(root.left);
        bst.add(root.val);
        midOrder(root.right);
    }

    private TreeNode cur(int left, int right, List<Integer> bst) {
        if(left > right) {
            return null;
        }
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode(bst.get(mid));
        root.left = cur(left, mid - 1, bst);
        root.right = cur(mid + 1, right, bst);
        return root;
    }
}
