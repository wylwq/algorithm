package htwz.leetcode.sort;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 *
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 *
 * @author wangyu
 * @since 2022/6/3 11:08
 */
public class Solution1636 {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) ->
                o1.getValue().equals(o2.getValue()) ? o2.getKey() - o1.getKey() : o1.getValue() - o2.getValue()));
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue() + index;
            for (int i = index; i < count; i++) {
                nums[i] = entry.getKey();
                index++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,3,2};
        int[] ints = frequencySort(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%d\n", ints[i]);
        }
    }

}
