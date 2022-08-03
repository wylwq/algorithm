package htwz.leetcode.string;

/**
 * 2315. 统计星号
 *
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。
 * 换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 *
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 *
 * @author wangyu
 * @since 2022/8/3 23:04
 */
public class Solution2315 {

    public static void main(String[] args) {
        String s = "l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }

    public static int countAsterisks(String s) {
        char[] chars = s.toCharArray();
        int count = -1;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '|') {
                ++count;
            } else {
                if ((count & 1) == 1 && chars[i] == '*') {
                    ans++;
                }
            }
        }
        return ans;
    }
}
