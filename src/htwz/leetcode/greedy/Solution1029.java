package htwz.leetcode.greedy;

import java.util.Arrays;

/**
 * 1029. 两地调度
 *
 * 思路：如果我们将 2N 个人都安排飞往 A 市，然后改变其中 N 飞往 B 市，那么所花费的成本就是 apriceA - apriceB
 *
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。
 * 第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 * @author wangyu
 * @since 2022/6/4 15:36
 */
public class Solution1029 {

    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200}};
        int minCost = twoCitySchedCost(costs);
        System.out.println(minCost);
    }
}