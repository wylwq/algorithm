package htwz.leetcode.hash;

/**
 * 2068. 检查两个字符串是否几乎相等
 *
 * 如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，
 * 那么我们称这两个字符串 word1 和 word2 几乎相等 。
 *
 * 给你两个长度都为 n 的字符串 word1 和 word2 ，如果 word1 和 word2 几乎相等 ，
 * 请你返回 true ，否则返回 false 。
 *
 * 一个字母 x 的出现 频率 指的是它在字符串中出现的次数。
 *
 * @author wangyu
 * @since 2022/6/7 20:23
 */
public class Solution2068 {

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] w1 = new int[26];
        for(char w : word1.toCharArray()) {
            w1[w - 'a'] = w1[w - 'a'] + 1;
        }
        int[] w2 = new int[26];
        for (char w : word2.toCharArray()) {
            w2[w - 'a'] = w2[w - 'a'] + 1;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(w1[i] - w2[i]) > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String word1 = "aaaa", word2 = "bccb";
        //String word1 = "abcdeef", word2 = "abaaacc";
        String word1 = "cccddabba", word2 = "babababab";
        boolean equivalent = checkAlmostEquivalent(word1, word2);
        System.out.println(equivalent);
    }
}
