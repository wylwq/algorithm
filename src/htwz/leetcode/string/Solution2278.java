package htwz.leetcode.string;

/**
 * 2278. 字母在字符串中的百分比
 *
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 *
 * @author wangyu
 * @since 2022/6/2 12:28
 */
public class Solution2278 {

    public static int percentageLetter(String s, char letter) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            if (c == letter) {
                ans++;
            }
        }
        return ans * 100 / s.length();
    }

    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        int i = percentageLetter(s, letter);
        System.out.println(i);
    }
}
