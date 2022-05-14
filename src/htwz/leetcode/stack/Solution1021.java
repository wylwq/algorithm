package htwz.leetcode.stack;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 *
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 * @author wangyu
 * @since 2022/5/14 7:13
 */
public class Solution1021 {

    public static void main(String[] args) {
        String s = "(()())(())";
        String parentheses = removeOuterParentheses(s);
        System.out.println(parentheses);
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder("");
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && point++ > 0) {
                ans.append(s.charAt(i));
            }
            if (s.charAt(i) == ')' && --point > 0) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
