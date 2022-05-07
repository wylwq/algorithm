package htwz.leetcode.hash;

/**
 * hash---好数对的数目
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * 组合公式：
 * v(v-1)/2
 * 思路：统计每个数字出现的次数，然后使用上面的公式求解
 *
 * @author wangyu
 * @since 2022/5/7 6:36
 */
public class Solution1512 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int pairs = numIdenticalPairs(nums);
        System.out.println(pairs);
    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    result++;
                }
            }
        }
        return result;
    }
}
