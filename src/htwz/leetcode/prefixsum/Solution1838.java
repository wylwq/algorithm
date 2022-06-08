package htwz.leetcode.prefixsum;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 *
 * 思路：参考https://leetcode.cn/problems/frequency-of-the-most-frequent-element/solution/hua-dong-chuang-kou-yong-zui-jian-dan-qi-r507/
 *
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 * @author wangyu
 * @since 2022/6/8 20:54
 */
public class Solution1838 {

    public static int maxFrequency(int[] nums, int k) {
        int ans = 1, j = 0;
        long sum = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            //计算区间内每个值，与区间内最后一个值相差的总和
            sum += (long) (nums[i] - nums[i - 1]) * (i - j);
            //如果超过目标值
            while (sum > k) {
                //那么就减去区间内最左侧的值与最后一个值的差距。
                //然后再让区间左侧向右移动一位，相等于整个区间缩小了一位距离，在缩小的区间内再判断是否满足要求
                sum -= nums[i] - nums[j];
                j++;
            }
            ans = Math.max(i - j + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        //int[] nums = {1,4,8,13};
        //int k = 5;
        //int[] nums = {3,9,6};
        //int k = 2;
        int frequency = maxFrequency(nums, k);
        System.out.println(frequency);
    }
}
