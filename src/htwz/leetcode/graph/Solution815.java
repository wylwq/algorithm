package htwz.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 851. 喧闹和富有
 *
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自洽（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 *
 * @author wangyu
 * @since 2022/5/28 21:23
 */
public class Solution815 {

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];
        int len = quiet.length;
        int[][] g = new int[len][len];
        int[] in = new int[len];
        for (int[] r : richer) {
            int a = r[0];
            int b = r[1];
            g[a][b] = 1;
            in[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            ans[i] = i;
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer p = q.poll();
            for (int i = 0; i < len; i++) {
                if(g[p][i] == 1) {
                    if (quiet[ans[p]] < quiet[ans[i]]) {
                        ans[i] = ans[p];
                    }
                    if (--in[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quite = {3,2,5,4,6,1,7,0};
        int[] ints = loudAndRich(richer, quite);
        System.out.println(ints);
    }
}
