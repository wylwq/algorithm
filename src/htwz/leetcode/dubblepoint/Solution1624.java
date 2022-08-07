package htwz.leetcode.dubblepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.24. 数对和
 *
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * @author wangyu
 * @since 2022/8/7 11:42
 */
public class Solution1624 {

    public static void main(String[] args) {
        int[] nums = {5,6,5};
        int target = 11;
        List<List<Integer>> lists = pairSums(nums, target);
        lists.forEach(l -> {
            System.out.println(l.toString());
        });
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (;i < j;) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                List<Integer> r = new ArrayList<>();
                r.add(nums[i++]);
                r.add(nums[j--]);
                ans.add(r);
            }
        }
        return ans;
    }

}
