package htwz.leetcode.binarytree;

import htwz.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145 二叉树的后序遍历
 *
 * @author wangyu
 * @since 2022/5/19 8:11
 */
public class Solution145 {

    public static void main(String[] args) {

    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        suffixOrder(root);
        return ans;
    }

    private void suffixOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        suffixOrder(root.left);
        suffixOrder(root.right);
        ans.add(root.val);
    }
}
