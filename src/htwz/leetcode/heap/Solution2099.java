package htwz.leetcode.heap;

import java.util.Arrays;

/**
 * 2099. 找到和最大的长度为 K 的子序列
 *
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 *
 * @author wangyu
 * @since 2022/5/21 23:14
 */
public class Solution2099 {

    public static void main(String[] args) {

    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int[][] sort = new int[nums.length][2];
        int[][] temp = new int[k][2];
        for(int i = 0; i < nums.length; i++) {
            sort[i] = new int[]{nums[i], i};
        }
        Arrays.sort(sort, (a, b) -> b[0] - a[0]);
        for(int i = 0; i < k; i++) {
            temp[i] = sort[i];
        }
        Arrays.sort(temp, (a, b) -> a[1] - b[1]);
        for(int i = 0; i < temp.length; i++) {
            ans[i] = temp[i][0];
        }
        return ans;
    }
}
