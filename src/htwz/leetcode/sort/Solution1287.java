package htwz.leetcode.sort;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * @author wangyu
 * @since 2022/6/3 11:49
 */
public class Solution1287 {

    public static int findSpecialInteger(int[] arr) {
        float p = arr.length * 0.25f;
        int ans = arr[0];
        for (int i = 1, index = 0; i < arr.length; i++) {
            if (ans != arr[i]) {
                if (i - index > p) {
                    return ans;
                }
                index = i;
                ans = arr[index];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,2,6,6,6,6,7,10};
        //int[] arr = {1,2,3,4,4};
        //int[] arr = {1,1,2,2,3,3,3,3};
        int[] arr = {0,0,2,2,2,4,4,4,6,6,10,10,10,10,10,12,14,16,16};
        int specialInteger = findSpecialInteger(arr);
        System.out.println(specialInteger);
    }
}
