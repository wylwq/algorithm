package htwz.leetcode.greedy;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * <p>
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * @author wangyu
 * @since 2023/1/7 15:05
 */
public class Solution019 {

  public static void main(String[] args) {
    String s = "abc";
    System.out.println(validPalindrome(s));
  }

  public static boolean validPalindrome(String s) {
    for (int low = 0, high = s.length() - 1; low < high; low++, high--) {
      if (s.charAt(low) != s.charAt(high)) {
        return validPalindrome(s, low + 1, high) || validPalindrome(s, low, high - 1);
      }
    }
    return true;
  }

  public static boolean validPalindrome(String s, int low, int high) {
    for (int i = low, j = high; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}