package htwz.leetcode.hash;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 *
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 *
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，
 * 那么请你返回 true ，否则返回 false 。
 *
 * @author wangyu
 * @since 2022/6/7 20:39
 */
public class Solution2283 {

    public static boolean digitCount(String num) {
        int[] tmp = new int[10];
        for(char c : num.toCharArray()) {
            tmp[c - 48] = tmp[c - 48] + 1;
        }
        for (int i = 0; i < num.length(); i++) {
            if (tmp[i] != num.charAt(i) - 48) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String num = "1210";
        String num = "6210001000";
        boolean digitCount = digitCount(num);
        System.out.println(digitCount);
    }
}
