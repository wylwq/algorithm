package htwz.leetcode;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * 排序 + 滑动窗口  (https://blog.csdn.net/WhereIsHeroFrom/article/details/120884741)
 * 从 nn 个元素里找 kk 个，使得 kk 个元素最大差值最小。
 * 最大值最小化问题容易想到「二分」，利用答案本身具有「二段性」，来将原本的求解问题转化为判断定问题。
 * 回到本题，容易证明，这 kk 个元素必然是有序数组中（排序后）的连续段。反证法，若最佳 kk 个选择不是连续段，能够调整为连续段，结果不会变差
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
