package htwz.leetcode.bsttree;

import htwz.leetcode.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 思想：分治思想
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 *
 * @author wangyu
 * @since 2022/5/20 8:10
 */
public class Solution108 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return cur(0, nums.length - 1, nums);
    }

    private TreeNode cur(int left, int right, int[] nums) {
        if(left > right) {
            return null;
        }
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = cur(left, mid - 1, nums);
        root.right = cur(mid + 1, right, nums);
        return root;
    }
}
