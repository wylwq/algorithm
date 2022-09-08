package htwz.leetcode.prefixsum;

/**
 * 2256. 最小平均差
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 *
 * 下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。
 * 两个平均值都需要 向下取整 到最近的整数。
 *
 * 请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
 *
 * @author wangyu
 * @since 2022/9/8 23:47
 */
public class Solution2256 {

  public static void main(String[] args) {
    int[] nums = {2,5,3,9,5,3};
    System.out.println(minimumAverageDifference(nums));
  }

  public static int minimumAverageDifference(int[] nums) {
    int ans = 0;
    long min = Long.MAX_VALUE;
    int len = nums.length;
    long[] sum = new long[len + 1];
    for (int i = 0; i < len; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    for (int i = 0; i < len; i++) {
      long diff = Math.abs(sum[i + 1] / (i + 1) - ((len - i - 1) == 0 ?
          0 : (sum[len] - sum[i + 1])/ (len - i - 1)));
      if (diff < min) {
        min = diff;
        ans = i;
      }
    }
    return ans;
  }

}
