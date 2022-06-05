package htwz.leetcode.dubblepoint;

import java.util.Arrays;

/**
 * 面试题 16.06. 最小差
 *
 * 思路1：对其中一个数组进行排序，遍历另一个数组，通过二分查找，寻找距离当前元素在 a 中最近的一个元素，最终找到最小值
 * 思路2: 将两个数组都进行 sort，将两个元素进行减法操作，将结果和当前已经存在的最小元素作比较，去最小值，同时移动较小元素的指针
 *
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * @author wangyu
 * @since 2022/6/5 12:59
 */
public class Solution1606 {

    public static int smallestDifference(int[] a, int[] b) {
        long ans = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int target : b) {
            int i = bSearch(a, target);
            int j = i + 1;
            //这里要用 long 来处理，因为 -2147483648 abs 之后，结果还是 -2147483648
            long leftMin = i < 0 ? Integer.MAX_VALUE : Math.abs((long)target - a[i]);
            long rightMin = j >= a.length ? Integer.MAX_VALUE : Math.abs((long)a[j] - target);
            long min = Math.min(leftMin, rightMin);
            ans = Math.min(ans, min);
        }
        return (int)ans;
    }

    public static int bSearch(int[] nums, int target) {
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] a = {1, 3, 15, 11, 2};
        //int[] b = {23, 127, 235, 19, 8};
        int[] a = {-2147483648,1};
        int[] b = {2147483647,0};
        int difference = smallestDifference(a, b);
        System.out.println(difference);
    }
}
