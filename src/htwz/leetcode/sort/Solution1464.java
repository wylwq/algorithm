package htwz.leetcode.sort;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 *
 * @author wangyu
 * @since 2022/6/3 10:31
 */
public class Solution1464 {

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        insertSort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            int temp = nums[i];
            while (index >= 0 && nums[index] > nums[i]) {
                nums[i] = nums[index];
                nums[index] = temp;
                index--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        int maxProduct = maxProduct(nums);
        System.out.println(maxProduct);
    }
}
