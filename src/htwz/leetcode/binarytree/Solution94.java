package htwz.leetcode.binarytree;

import htwz.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author wangyu
 * @since 2022/5/19 8:10
 */
public class Solution94 {

    public static void main(String[] args) {

    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        midOrder(root);
        return ans;
    }

    private void midOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        midOrder(root.left);
        ans.add(root.val);
        midOrder(root.right);
    }
}
