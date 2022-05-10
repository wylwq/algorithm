package htwz.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * @author wangyu
 * @since 2022/5/10 7:06
 */
public class Solution137 {

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        /*int number = singleNumber(nums);*/
        int number = singleNumberV2(nums);
        System.out.println(number);
    }

    //朴素做法
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 每个二进制位单独计数，最后统计每个二进制位的1的数量 mod 3的余数。复杂度O(32 * N)，勉强算线性复杂度
     * [2, 2, 3, 2]
     * 0	0	1	0
     * 1	1	1	1
     * 0	0	0	0
     */
    public static int singleNumberV2(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int ans = 0;
            for (int j = 0; j < nums.length; j++) {
                System.out.printf("%d\t", (nums[j] >> i) & 1);
                ans += (nums[j] >> i) & 1;
            }
            System.out.println();
            ans %= 3;
            if (ans > 0) {
                ret += (1 << i);
            }
        }
        return ret;
    }
}
