package htwz.leetcode.dynamic;

/**
 * 最长递增子序列
 *
 * @author wangyu
 * @since 2023/1/5 23:25
 */
public class Solution9999 {

  public static void main(String[] args) {
    int[] a = {1,5,2,4,3};
    int max = 1;
    for (int i = 0; i < a.length; i++) {
      max = Math.max(max, a(a, i));
    }
    System.out.println(max);
    for (int i : memo) {
      System.out.println(i);
    }
  }

  static int[] memo = new int[5];

  private static int a(int[] a, int i) {
    if (memo[i] != 0) {
      return memo[i];
    }
    int max = 1;
    for (int j = i + 1; j < a.length; j++) {
      if (a[i] < a[j]) {
        max = Math.max(max, a(a, j) + 1);
      }
    }
    memo[i] = max;
    return max;
  }
}
