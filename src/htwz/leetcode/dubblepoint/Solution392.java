package htwz.leetcode.dubblepoint;

/**
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @author wangyu
 * @since 2022/9/5 23:14
 */
public class Solution392 {

  public static void main(String[] args) {
    String s = "abc";
    String t = "ahbgdc";
    System.out.println(isSubsequence(s, t));
  }

  public static boolean isSubsequence(String s, String t) {
    char[] cs = s.toCharArray();
    char[] ct = t.toCharArray();
    int i = 0, j = 0;
    while (i < cs.length && j < ct.length) {
      if (cs[i] == ct[j]) {
        i++;
      }
      j++;
    }
    return i == cs.length;
  }

}