package htwz.leetcode.dynamic;

/**
 * 53.最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * @author wangyu
 * @since 2022/5/30 9:29
 */
public class Solution53 {

    /**
     * 贪心算法
     * 1 当前数组下标的值大于当前数组下标之前的和的值，那么取当前数组下标的值作为最大值
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0], curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            ans = Math.max(ans, curSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
}
