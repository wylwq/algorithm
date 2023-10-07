package htwz.leetcode.dynamic;

/**
 * 面试题 05.03. 翻转数位
 *
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * @author wangyu
 * @since 2023/1/12 21:16
 */
public class Solution0503 {

  public static void main(String[] args) {
    //11011101111
    int num = 1775;
    System.out.println(reverseBits(num));
  }

  public static int reverseBits(int num) {
    int cur = 0;
    int max = 0;
    int tmp = 0;
    for (int i = 0; i < 32; i++) {
      if ((num & 1 << i) != 0) {
        cur++;
        tmp++;
      } else {
        tmp = cur + 1;
        cur = 0;
      }
      max = Math.max(tmp, max);
    }
    return max;
  }

}
