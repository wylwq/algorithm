package htwz.leetcode.array;

/**
 * 1588. 所有奇数长度子数组的和
 *
 * 思路：利用滑动窗口，可以减少计算的重复部分
 *
 * @author wangyu
 * @since 2022/6/1 9:30
 */
public class Solution1588 {

    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int k = 1; k <= arr.length; k+=2) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i < k) {
                    sum += arr[i];
                } else {
                    sum += arr[i] - arr[i - k];
                }
                if (i >= (k - 1)) {
                    ans += sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2, 5, 3};
        int ans = sumOddLengthSubarrays(arr);
        System.out.println(ans);
    }
}
