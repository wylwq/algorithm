package htwz.leetcode.dubblepoint;

/**
 * 2000. 反转单词前缀
 *
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。
 * 找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。
 * 如果 word 中不存在字符 ch ，则无需进行任何操作。
 *
 * @author wangyu
 * @since 2022/6/5 10:51
 */
public class Solution2000 {

    public static String reversePrefix(String word, char ch) {
        int firstIndex = -1;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                firstIndex = i;
                break;
            }
        }
        for (int i = 0, j = firstIndex; i < j; i++, j--) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        String prefix = reversePrefix(word, ch);
        System.out.println(prefix);
    }
}
