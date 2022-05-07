package htwz.leetcode.slidingwindow;

import java.util.Arrays;

/**
 * 排序 + 滑动窗口  (https://blog.csdn.net/WhereIsHeroFrom/article/details/120884741)
 *
 * @author wangyu
 * @since 2022/5/6 6:39
 */
public class Solution1984 {

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
        int ans = minimumDifference(nums, k);
        System.out.println(ans);
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}
