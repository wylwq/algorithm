package htwz.leetcode.dubblepoint;

/**
 * 917. 仅仅反转字母
 *
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 * @author wangyu
 * @since 2022/6/5 11:03
 */
public class Solution917 {

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j;) {
            boolean ci = checkLetters(chars[i]);
            boolean cj = checkLetters(chars[j]);
            if (ci && cj) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            if (!ci) {
                i++;
            }
            if (!cj) {
                j--;
            }
        }
        return new String(chars);
    }

    private static boolean checkLetters(char c) {
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //String s = "ab-cd";
        String s = "7_28]";
        String s1 = reverseOnlyLetters(s);
        System.out.println(s1);
    }
}
