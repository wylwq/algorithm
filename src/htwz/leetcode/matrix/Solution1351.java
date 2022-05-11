package htwz.leetcode.matrix;

/**
 * 1351. 统计有序矩阵中的负数
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 * @author wangyu
 * @since 2022/5/11 7:32
 */
public class Solution1351 {

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int negatives = countNegatives(grid);
        System.out.println(negatives);
    }

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    ans += 1;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
