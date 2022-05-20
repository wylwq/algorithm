package htwz.leetcode.bsttree;

import htwz.leetcode.tree.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * 思路: 需要维护一个递增的变量来控制，如果当前递增的变量与 k 相同表示，满足条件，
 * 不能通过参数传递一个 k-- 来控制结果，因为树同一层他们的 k 值是一样的，因此结果就会保存到同一层的最右边那个节点值
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author wangyu
 * @since 2022/5/20 8:09
 */
public class Solution230 {

    public static void main(String[] args) {

    }

    int ans = -1;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        cur(root, k);
        return ans;
    }

    public void cur(TreeNode root, int k){
        if(root == null){
            return;
        }
        cur(root.left, k);
        cnt++;
        if(cnt == k){
            ans = root.val;
            return;
        }
        cur(root.right, k);
    }
}
