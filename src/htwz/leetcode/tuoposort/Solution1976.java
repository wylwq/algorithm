package htwz.leetcode.tuoposort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1976. 到达目的地的方案数
 *
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，
 * 某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
 * 给你一个整数 n 和二维整数数组 roads ，
 * 其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。
 * 你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
 *
 * @author wangyu
 * @since 2022/5/30 17:09
 */
public class Solution1976 {

    public static int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][n];
        long[] dis = new long[n];
        dis[0] = 0;
        Arrays.fill(dis, Long.MAX_VALUE);
        //build 无向图
        for(int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        Queue<long[]> p = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        //起点从 0 开始，并且到自身的距离为 0
        p.add(new long[]{0, 0});
        //记录是否被访问过
        boolean[] isVisited = new boolean[n];
        //记录有多少种方案
        long[] cnt = new long[n];
        cnt[0] = 1;
        while(!p.isEmpty()) {
            long[] poll = p.poll();
            int u = (int)poll[0];
            //标记已被范围
            if(isVisited[u]) {
                continue;
            }
            isVisited[u] = true;
            for(int v = 0; v < n; v++) {
                //cost
                long w = graph[u][v];
                //u -> v 之间可达
                if(w != 0) {
                    if(dis[v] > dis[u] + w) {
                        cnt[v] = cnt[u];
                        dis[v] = dis[u] + w;
                        p.add(new long[]{v, dis[u] + w});
                    } else if(dis[v] == dis[u] + w) {
                        cnt[v] = (cnt[v] + cnt[u]) % 1000000007;
                    }
                }
            }
        }
        return (int) cnt[n - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int paths = countPaths(n, roads);
        System.out.println(paths);
    }
}
