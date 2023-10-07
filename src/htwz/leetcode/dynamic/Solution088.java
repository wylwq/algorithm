package htwz.leetcode.dynamic;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 *
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * @author wangyu
 * @since 2023/1/14 15:54
 */
public class Solution088 {

  public static void main(String[] args) {
    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(minCostClimbingStairs(cost));
  }

  public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i <= cost.length; i++) {
      dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
    }
    return dp[cost.length];
  }

}
