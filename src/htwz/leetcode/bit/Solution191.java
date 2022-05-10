package htwz.leetcode.bit;

/**
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * @author wangyu
 * @since 2022/5/10 6:10
 */
public class Solution191 {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int weight = hammingWeight(n);
        System.out.println(weight);
    }

    //输入必须是长度为 32 的 二进制串
    public static int hammingWeight(int n) {
        int ans = 0;
        for (int i = 1; i <= 32; i++) {
            ans += n & 1;
            n = n >>1;
        }
        return ans;
    }


}
