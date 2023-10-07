package htwz.leetcode.dynamic;

/**
 * 面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * @author wangyu
 * @since 2023/1/10 23:00
 */
public class Solution1716 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    System.out.println(massage(nums));
  }

  public static int massage(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      // 今天在选与不选中，选择一个最优的
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }

}
