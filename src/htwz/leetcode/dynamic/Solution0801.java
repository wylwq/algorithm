package htwz.leetcode.dynamic;

/**
 * 面试题 08.01. 三步问题
 *
 * @author wangyu
 * @since 2023/1/12 21:44
 */
public class Solution0801 {

  public static void main(String[] args) {
    System.out.println(waysToStep(5));
  }

  public static int waysToStep(int n) {
    if (n <= 2) {
      return n;
    }
    if (n == 3) {
      return 4;
    }
    int[] dp = new int[n + 1];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3];
      dp[i] %= 1000000007;
    }
    return dp[n];
  }

}
