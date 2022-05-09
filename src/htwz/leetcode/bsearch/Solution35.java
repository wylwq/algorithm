package htwz.leetcode.bsearch;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @author wangyu
 * @since 2022/5/9 10:39
 */
public class Solution35 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        //int insert = searchInsert(nums, target);
        int insert = bSearch(nums, target);
        System.out.println(insert);
    }

    public static int searchInsert(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i] || target < nums[i]) {
                ans = i;
                break;
            }
        }
        if (target > nums[nums.length - 1]) {
            ans = nums.length;
        }
        return ans;
    }

    private static int bSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
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
