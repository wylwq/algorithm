package htwz.leetcode.binarytree;

import htwz.leetcode.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 104. 二叉树的最大深度
 *
 * @author wangyu
 * @since 2022/5/19 8:11
 */
public class Solution104 {

    public static void main(String[] args) {

    }

    Set<Integer> ans = new HashSet<>();

    public int maxDepth(TreeNode root) {
        depth(root, 0);
        return ans.size();
    }

    private void depth(TreeNode root, Integer depth) {
        if(root == null) {
            return;
        }
        ans.add(depth);
        depth(root.left, depth + 1);
        depth(root.right, depth + 1);
    }


}
