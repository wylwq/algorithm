package htwz.leetcode.matrix;

import java.util.Arrays;

/**
 * 面试题 01.08. 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * @author wangyu
 * @since 2022/8/13 8:27
 */
public class Solution0108 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int[][] tmp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            tmp[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (tmp[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }

}