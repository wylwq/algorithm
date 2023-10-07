package htwz.leetcode.dynamic;

/**
 * 面试题 16.17. 连续数列
 * <p>
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * @author wangyu
 * @since 2023/1/12 21:02
 */
public class Solution1617 {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  public static int maxSubArray(int[] nums) {
    int size = nums.length;
    if (size == 1) {
      return nums[0];
    }
    int sum = nums[0];
    int[] max = new int[size + 1];
    for (int i = 1; i < size; i++) {
      if (max[i - 1] >= 0) {
        max[i] = max[i - 1] + nums[i];
      } else {
        max[i] = nums[i];
      }
      sum = Math.max(sum, max[i]);
    }
    return sum;
  }

}
