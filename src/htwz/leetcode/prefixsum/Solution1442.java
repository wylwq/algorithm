package htwz.leetcode.prefixsum;

/**
 * 1442. 形成两个异或(二进制为相同为0不同为1)相等数组的三元组数目
 * a ^ b = a[i]^...^a[k] = 0, 题目转化为求子串的异或结果等于0
 *
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * @author wangyu
 * @since 2022/5/8 21:11
 */
public class Solution1442 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        int triplets = countTriplets(arr);
        System.out.println(triplets);
    }

    public static int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                t ^= arr[k];
                if (t == 0) {
                    // j可以是i~k任意一个数都行
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
