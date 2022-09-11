package htwz.leetcode.matrix;

/**
 * 1975. 最大方阵和
 *
 * 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 *
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 *
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和
 *
 * @author wangyu
 * @since 2022/9/11 22:52
 */
public class Solution1975 {

  public static void main(String[] args) {
    int[][] matrix = {{1,-1},{-1,1}};
    System.out.println(maxMatrixSum(matrix));
  }

  public static long maxMatrixSum(int[][] matrix) {
    long ans = 0;
    int count = 0, min = Integer.MAX_VALUE;
    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (ints[j] < 0) {
          count++;
        }
        min = Math.min(min, Math.abs(ints[j]));
        ans += Math.abs(ints[j]);
      }
    }
    return (count & 1) == 0 ? ans : ans - min * 2L;
  }

}
