package htwz.leetcode.array;

/**
 * 1848. 到目标元素的最小距离
 *
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，
 * 满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 * 返回 abs(i - start) 。
 * 题目数据保证 target 存在于 nums 中。
 *
 * @author wangyu
 * @since 2022/6/1 10:03
 */
public class Solution1848 {

    public static int getMinDistance(int[] nums, int target, int start) {
        int ans = 10001;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(Math.abs(start - i), ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5, start = 3;
        int minDistance = getMinDistance(nums, target, start);
        System.out.println(minDistance);
    }

}
