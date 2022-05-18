package htwz.leetcode.tree;

/**
 * 2236. 判断根结点是否等于子结点之和
 *
 * @author wangyu
 * @since 2022/5/18 7:40
 */
public class Solution2236 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(4);
        t.left = left;
        t.right = right;
        TreeNode sum = new TreeNode(0);
        boolean b = checkTree(t, sum);
        System.out.println(b);
    }

    public static boolean checkTree(TreeNode root, TreeNode sum) {
        int rootVal = root.val;
        prefixOrder(root, sum);
        return sum.val - root.val == rootVal;
    }

    private static void prefixOrder(TreeNode root, TreeNode sum) {
        if(root == null) {
            return;
        }
        sum.val += root.val;
        prefixOrder(root.left, sum);
        prefixOrder(root.right, sum);
    }
}
