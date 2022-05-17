package htwz.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author wangyu
 * @since 2022/5/17 7:04
 */
public class Solution102 {

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        if (ans.get(0) == null) {
            ans.set(0, 1);
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            ans.add(new ArrayList<>());
            return ans;
        }
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int level) {
        if(ans.get(level) == null) {
            ans.set(level, new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if(root.left != null) {
            dfs(root, level+1);
        }
        if(root.right != null) {
            dfs(root.right, level+1);
        }
    }
}
