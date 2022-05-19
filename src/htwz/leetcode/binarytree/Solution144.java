package htwz.leetcode.binarytree;

import htwz.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 二叉树的前序遍历
 *
 * @author wangyu
 * @since 2022/5/19 8:08
 */
public class Solution144 {

    public static void main(String[] args) {

    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        prefixOrder(root);
        return ans;
    }

    private void prefixOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        prefixOrder(root.left);
        prefixOrder(root.right);
    }
}
