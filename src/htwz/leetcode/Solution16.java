package htwz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode第16题
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 *
 * @author : wangyu
 * @since :  2020/12/25/025 9:30
 */
public class Solution16 {

    public static void main(String[] args) {
        int[][] land = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        int[] result = pondSizes(land);
        System.out.println(Arrays.toString(result));
    }

    private static int[] pondSizes(int[][] land) {
        List<Integer> loadCount = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int count = dfs(land, i, j);
                    loadCount.add(count);
                }
            }
        }

        int[] count = new int[loadCount.size()];
        for (int i = 0; i < loadCount.size(); i++) {
            count[i] = loadCount.get(i);
        }
        Arrays.sort(count);
        return count;
    }

    private static int dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int count = 1;
        count += dfs(land, i + 1, j);
        count += dfs(land, i - 1, j);
        count += dfs(land, i, j + 1);
        count += dfs(land, i, j - 1);
        count += dfs(land, i+1, j+1);
        count += dfs(land, i-1, j+1);
        count += dfs(land, i-1, j-1);
        count += dfs(land, i+1, j-1);
        return count;
    }

}
