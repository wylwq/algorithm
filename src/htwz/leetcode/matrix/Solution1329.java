package htwz.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 1329. 将矩阵按对角线排序
 *
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 *
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *
 * @author wangyu
 * @since 2022/5/11 8:00
 */
public class Solution1329 {

    public static void main(String[] args) {
        int[][] mat = {{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}};
        int[][] ints = diagonalSort(mat);
        prinf(ints);
    }

    private static void prinf(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%d\t", mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //先竖着翻转, 在横着翻转
    public static int[][] diagonalSort(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        //先遍历右上部分
        for (int i = 0; i < col; i++) {
            sortMatrix(mat, row, col, 0, i);
        }
        //遍历左下部分
        for (int i = 1; i < row; i++) {
            sortMatrix(mat, row, col, i, 0);
        }
        return mat;
    }

    private static void sortMatrix(int[][] mat, int row, int col, int mr, int mc) {
        List<Integer> tmp = new ArrayList<>();
        int m = mr, n = mc;
        while (mr < row && mc < col) {
            tmp.add(mat[mr][mc]);
            mr++;
            mc++;
        }
        tmp.sort(Integer::compareTo);
        mr = m;
        mc = n;
        int j = 0;
        while (j < tmp.size()) {
            mat[mr][mc] = tmp.get(j);
            mr++;
            mc++;
            j++;
        }
    }
}