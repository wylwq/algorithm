package htwz.leetcode.hash;

/**
 * 制造字母异位词的最小步骤数--- hash
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * @author wangyu
 * @since 2022/5/8 6:25
 */
public class Solution1347 {

    public static void main(String[] args) {
        String s = "bab";
        String t = "aba";
        int steps = minSteps(s, t);
        System.out.println(steps);
    }

    public static int minSteps(String s, String t) {
        int result = 0;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] letter = new int[26];
        for (int i = 0; i < cs.length; i++) {
            letter[cs[i] - 'a'] = letter[cs[i] - 'a'] + 1;
        }
        for (int i = 0; i < ts.length; i++) {
            letter[ts[i] - 'a'] = letter[ts[i] - 'a'] - 1;
        }
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > 0) {
                result += letter[i];
            }
        }
        return result;
    }
}
