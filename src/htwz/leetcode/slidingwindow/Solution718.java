package htwz.leetcode.slidingwindow;

/**
 * 718. 最长重复子数组
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * @author wangyu
 * @since 2022/9/6 23:22
 */
public class Solution718 {

  public static void main(String[] args) {
    int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
    System.out.println(findLength(nums1, nums2));
  }

  public static int findLength(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int len = Math.min(m, n - i);
      int maxLen = maxLength(nums1, nums2, i, 0, len);
      ans = Math.max(ans, maxLen);
    }
    for (int i = 0; i < m; i++) {
      int len = Math.min(n, m - i);
      int maxLen = maxLength(nums1, nums2, 0, i, len);
      ans = Math.max(ans, maxLen);
    }
    return ans;
  }

  private static int maxLength(int[] nums1, int[] nums2, int i, int j, int len) {
    int ret = 0, k = 0;
    for (int l = 0; l < len; l++) {
      if (nums1[i + l] == nums2[j + l]) {
        k++;
      } else {
        k = 0;
      }
      ret = Math.max(ret, k);
    }
    return ret;
  }

}
