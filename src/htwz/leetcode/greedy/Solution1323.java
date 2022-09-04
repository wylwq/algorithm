package htwz.leetcode.greedy;

/**
 * 1323. 6 和 9 组成的最大数字
 *
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 *
 * @author wangyu
 * @since 2022/9/4 22:27
 */
public class Solution1323 {

  public static void main(String[] args) {
    int num = 9669;
    System.out.println(maximum69Number(num));
  }

  public static int maximum69Number (int num) {
    String s = Integer.toString(num);
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '6') {
        chars[i] = '9';
        break;
      }
    }
    return Integer.parseInt(new String(chars));
  }

}
