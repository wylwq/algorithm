package htwz.leetcode;

/**
 * 所有元音按顺序排布的最长子字符串---滑动窗口
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 *
 * @author wangyu
 * @since 2022/5/7 6:23
 */
public class Solution1839 {

    public static void main(String[] args) {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        int substring = longestBeautifulSubstring(word);
        System.out.println(substring);
    }

    public static int longestBeautifulSubstring(String word) {
        int max = 0, num = 1;
        for(int i = 0, j = 1; j < word.length(); j++) {
            if (word.charAt(j) < word.charAt(j - 1)) {
                i = j;
                num = 1;
            } else if (word.charAt(j) > word.charAt(j - 1)){
                num++;
            }
            if (num == 5) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
