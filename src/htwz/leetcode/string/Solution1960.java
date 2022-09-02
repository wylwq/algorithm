package htwz.leetcode.string;

/**
 * 1961. 检查字符串是否为数组前缀
 * <p>
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words
 * 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 *
 * @author wangyu
 * @since 2022/9/2 23:48
 */
public class Solution1960 {

  public static void main(String[] args) {
    String s = "iloveleetcode";
    String[] words = {"i", "love", "leetcode", "apples"};
    System.out.println(isPrefixString(s, words));
  }

  public static boolean isPrefixString(String s, String[] words) {
    StringBuilder builder = new StringBuilder();
    for (String str : words) {
      builder.append(str);
      if (s.equals(builder.toString())) {
        return true;
      }
    }
    return false;
  }

}
