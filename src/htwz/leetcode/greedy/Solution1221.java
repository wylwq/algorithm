package htwz.leetcode.greedy;

/**
 * 1221. 分割平衡字符串
 *
 * 思路: 如果出现一个 R 那么就 + 1，如果出现一个 L 那么就 - 1，当 sum == 0 时，满足最小平衡字符串
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 * @author wangyu
 * @since 2022/6/4 14:53
 */
public class Solution1221 {

    public static int balancedStringSplit(String s) {
        int ans = 0, sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'L' == 0 ? 1 : -1;
            if (sum == 0) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int split = balancedStringSplit(s);
        System.out.println(split);
    }
}
