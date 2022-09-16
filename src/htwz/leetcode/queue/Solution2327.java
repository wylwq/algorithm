package htwz.leetcode.queue;

/**
 * 2327. 知道秘密的人数
 *
 * 在第 1 天，有一个人发现了一个秘密。
 *
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。
 * 同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。
 * 一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 *
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。
 * 由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 *
 *
 * @author wangyu
 * @since 2022/9/16 23:46
 */
public class Solution2327 {

  public static void main(String[] args) {
    System.out.println(peopleAwareOfSecret(6, 2, 4));
  }

  public static int peopleAwareOfSecret(int n, int delay, int forget) {
    long mod = 1000000007;
    int[] dp = new int[1001];
    //表示第 i 天获得秘密的人数
    dp[1] = 1;
    int i, j;
    for (i = 1; i < n; i++) {
      for (j = i + delay; j < i + forget & j <= n; j++) {
        dp[j] += dp[i];
        if (dp[j] >= mod) {
          dp[j] -= mod;
        }
      }
    }
    int sum = 0;
    for (i = n - forget + 1; i <= n; i++) {
      sum += dp[i];
      if (sum >= mod) {
        sum -= mod;
      }
    }
    return sum;
  }
}
