package htwz.leetcode.dfs;

/**
 * 1219. 黄金矿工
 * 思路：深度遍历和回溯
 *
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
 * 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 * @author wangyu
 * @since 2022/5/15 20:35
 */
public class Solution1219 {

    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int maximumGold = getMaximumGold(grid);
        System.out.println(maximumGold);
    }

    private static int row;
    private static int col;
    public static int getMaximumGold(int[][] grid) {
        int ans = 0;
        row = grid.length;
        col = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(grid, i, j, 0));
                }
            }
        }
        return ans;
    }

    private static int dfs(int[][] grid, int i, int j, int ans) {
        if(i >= row || i < 0 || j >= col || j < 0 || grid[i][j] == 0) {
            return ans;
        }
        int tmp = grid[i][j];
        grid[i][j] = 0;
        int a = dfs(grid, i + 1, j, ans + tmp);
        int b = dfs(grid, i - 1, j, ans + tmp);
        int c = dfs(grid, i, j + 1, ans + tmp);
        int d = dfs(grid, i, j - 1, ans + tmp);
        grid[i][j] = tmp;
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
