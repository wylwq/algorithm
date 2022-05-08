package htwz.leetcode.prefixsum;

/**
 * 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和
 *
 * 思路：
 * 1. 求出，奇数边界，
 * 2. 利用经典固定滑动窗口求解
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * @author wangyu
 * @since 2022/5/8 6:56
 */
public class Solution1588 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        int sum = sumOddLengthSubarrays(arr);
        System.out.println(sum);
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        len = len % 2 == 0 ? len - 1 : len;
        int ans = 0;
        for (int k = 1; k <= len; k = k + 2) {
            int signSum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i < k) {
                    signSum = signSum + arr[i];
                } else {
                    signSum = signSum + arr[i] - arr[i - k];
                }
                if (i >= (k - 1)) {
                    ans = ans + signSum;
                }
            }
        }
        return ans;
    }
}
