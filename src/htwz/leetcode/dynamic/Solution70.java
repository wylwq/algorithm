package htwz.leetcode.dynamic;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author wangyu
 * @since 2022/5/30 8:50
 */
public class Solution70 {

    /**
     * 这里会记录每个阶梯的解法
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 滚动式，每次只会记录 f(n -1) 与 f(n - 2) 的结果
     */
    public static int climbStairs2(int n) {
        int fx = 1;
        int fy = 2;
        if (n == 1) {
            return fx;
        }
        if (n == 2) {
            return fy;
        }
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = fx + fy;
            fx = fy;
            fy = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }
}
