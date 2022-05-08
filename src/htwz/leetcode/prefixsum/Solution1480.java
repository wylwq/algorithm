package htwz.leetcode.prefixsum;

/**
 * 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
 *
 * @author wangyu
 * @since 2022/5/8 6:36
 */
public class Solution1480 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = runningSum(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%d\t", ints[i]);
        }
    }

    public static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int signSum = ans[i - 1];
            signSum = signSum + nums[i];
            ans[i] = signSum;
        }
        return ans;
    }
}
