package htwz.leetcode.bfs;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LCP 44. 开幕式焰火
 *
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色
 *
 * 输入：root = [1,3,2,1,null,2]
 *
 * 输出：3
 *
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 *
 * @author wangyu
 * @since 2022/5/17 6:58
 */
public class SolutionLCP44 {

    public static void main(String[] args) {

    }

    Set<Integer> ans = new HashSet<Integer>();

    public int numColor(TreeNode root) {
        bfs(root);
        return ans.size();
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(!ans.contains(node.val)) {
                ans.add(node.val);
            }
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
    }
}
