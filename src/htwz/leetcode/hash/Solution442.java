package htwz.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 *
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 * @author wangyu
 * @since 2022/6/7 20:16
 */
public class Solution442 {

    public static List<Integer> findDuplicates(int[] nums) {
        int[] tmp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] = tmp[nums[i]] + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] >= 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }

}
