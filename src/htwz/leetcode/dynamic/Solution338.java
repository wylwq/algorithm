package htwz.leetcode.dynamic;

/**
 * 338. 比特位计数
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * @author wangyu
 * @since 2023/1/8 22:53
 */
public class Solution338 {

  public static void main(String[] args) {
    int[] ints = countBits(5);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  /**
   * for(int i = 1; i <= num; i++) {
   *   if(i % 2 == 1) {
   *      //奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
   *      result[i] = result[i-1] + 1;
   *   } else {
   *     //二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
   *     //因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的
   *      result[i] = result[i/2];
   *   }
   * }
   *
   * @param n n
   * @return int[]
   */
  public static int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int bitCount = Integer.bitCount(i);
      ans[i] = bitCount;
    }
    return ans;
  }

}
