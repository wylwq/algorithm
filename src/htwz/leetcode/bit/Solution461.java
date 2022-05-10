package htwz.leetcode.bit;

/**
 * 461. 汉明距离
 * 思路: 使用异或运算，相同为零，不同为一
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置
 *
 * @author wangyu
 * @since 2022/5/10 6:30
 */
public class Solution461 {

    public static void main(String[] args) {
        int x = 3, y = 1;
        int distance = hammingDistance(x, y);
        System.out.println(distance);
    }

    public static int hammingDistance(int x, int y) {
        int ret = x^y;
        int ans = 0;
        for (int i = 1; i <= 32; i++) {
            ans += ret & 1;
            ret = ret >> 1;
        }
        return ans;
    }
}
