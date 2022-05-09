package htwz.leetcode.bsearch;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 思路：使用二分查找，找出等于 target 或者 第一个大于 target 的下标，然后再找出 target + 1 的下标，二者相减就是答案
 *
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * @author wangyu
 * @since 2022/5/9 11:36
 */
public class Solution53 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int ans = search(nums, target);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int index = bSearch(nums, target);
        if (index == nums.length || nums[index] != target) {
            return 0;
        }
        return bSearch(nums, target) - index - 1;
    }

    public static int bSearch(int[] nums, int target) {
        int ans = nums.length, l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
