package htwz.leetcode.string;

/**
 * 1071. 字符串的最大公因子
 *
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
 *
 * 思路：
 * 我们知道前缀串的长度必然要是两个字符串长度的约数才能满足条件，否则无法经过若干次拼接后得到长度相等的字符串
 *
 * @author wangyu
 * @since 2022/6/2 16:37
 */
public class Solution1071 {

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    private static boolean check(String X, String s) {
        int lenX = s.length() / X.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= lenX; i++) {
            ans.append(X);
        }
        return ans.toString().equals(s);
    }

    public static void main(String[] args) {
        //String str1 = "ABCABC", str2 = "ABC";
        String str1 = "ABABABAB", str2 = "ABAB";
        //String str1 = "LEET", str2 = "CODE";
        //String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX", str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        //String str1 = "CXTXNCXTXNCXTXNCXTXNCXTXN", str2 = "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN";
        String s = gcdOfStrings(str1, str2);
        System.out.println(s);
    }

}
