package htwz.leetcode.greedy;

/**
 * 面试题 10.11. 峰与谷
 *
 * 思路：i % 2 != 0 表示 谷，否则为 峰，如果为峰的情况下，前一个值大于当前值则交换，
 * 否则不交换，同理，如果当前值为谷，前一个值小于当前值则交换，否则不交换
 *
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 *
 * @author wangyu
 * @since 2022/6/4 16:22
 */
public class Solution1011 {

    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //谷
            if (i % 2 != 0) {
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 2, 3};
        wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
