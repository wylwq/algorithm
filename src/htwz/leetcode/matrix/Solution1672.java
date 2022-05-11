package htwz.leetcode.matrix;

/**
 * 1672. 最富有客户的资产总量
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 *
 * @author wangyu
 * @since 2022/5/11 7:43
 */
public class Solution1672 {

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        int maximumWealth = maximumWealth(accounts);
        System.out.println(maximumWealth);
    }

    public static int maximumWealth(int[][] accounts) {
        int ret = 0, row = accounts.length, col = accounts[0].length;
        for (int i = 0; i < row; i++) {
            int ans = 0;
            for (int j = 0; j < col; j++) {
                ans += accounts[i][j];
            }
            ret = Math.max(ans, ret);
        }
        return ret;
    }
}
