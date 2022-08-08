package htwz.leetcode.hash;

/**
 * 1497. 检查数组对是否可以被 k 整除
 *
 * 思路：任意两个数相加等于某一个数，那么它们的余数相加也等于那个数
 *
 * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 *
 * @author wangyu
 * @since 2022/8/9 6:30
 */
public class Solution1497 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] tmp = new int[100010];
        for (int i = 0; i < arr.length; i++) {
            tmp[Math.floorMod(arr[i], k)]++;
        }
        if ((tmp[0] & 1) == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (tmp[i] != tmp[k - i]) {
                return false;
            }
        }
        return true;
    }
}
