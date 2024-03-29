package htwz.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1110. 删点成林
 * 思路：如果当前节点没有子节点可以直接删除，如果当前节点是被删除节点，并且有子节点的情况下，只要子节点不是被删除的节点，这是，子节点就可以成为森林
 * 通过一个标记把父节点的删除状态传递给子节点，
 * 然后通过返回值把子节点的状态返回给父亲节点，
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 返回森林中的每棵树。你可以按任意顺序组织答案
 *
 * @author wangyu
 * @since 2022/5/18 23:51
 */
public class Solution1110 {

    public static void main(String[] args) {

    }

    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        del(root, to_delete, true);
        return ans;
    }

    private TreeNode del(TreeNode root, int[] to_delete, boolean del) {
        if(root == null) {
            return null;
        }
        boolean currDel = checkInclude(root, to_delete);
        if(del && !currDel) {
            ans.add(root);
        }
        root.left = del(root.left, to_delete, currDel);
        root.right = del(root.right, to_delete, currDel);
        return currDel ? null : root;
    }

    private boolean checkInclude(TreeNode root, int[] to_delete) {
        for(int i = 0; i < to_delete.length; i++) {
            if(root.val == to_delete[i]) {
                return true;
            }
        }
        return false;
    }
}
