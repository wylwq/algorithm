package htwz.leetcode.bit;

/**
 * 868. 二进制间距
 *
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * @author wangyu
 * @since 2022/8/13 8:11
 */
public class Solution868 {

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }

    public static int binaryGap(int n) {
        int pre = -1, next = 0, ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    ans = Math.max(next - pre, ans);
                }
                pre = next;
            }
            next++;
            n = n >> 1;
        }
        return ans;
    }
}
