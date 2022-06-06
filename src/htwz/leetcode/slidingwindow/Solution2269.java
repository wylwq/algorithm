package htwz.leetcode.slidingwindow;

/**
 * 2269. 找到一个数字的 K 美丽值
 *
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 *
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 *
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 *
 * @author wangyu
 * @since 2022/6/6 23:05
 */
public class Solution2269 {

    public static int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int i = 0, j = k;
        int len = str.length();
        int ans = 0;
        while (j <= len){
            String sub = str.substring(i, j);
            if(Integer.parseInt(sub)!=0&& num% Integer.parseInt(sub)==0){
                ans++;
            }
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        int divisorSubstrings = divisorSubstrings(num, k);
        System.out.println(divisorSubstrings);
    }
}
