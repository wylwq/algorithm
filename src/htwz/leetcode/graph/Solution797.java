package htwz.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * 我们从 0 开始出发，记录下来沿途经过的所有节点，往下深搜即可。
 * 注意回溯的时候 ArrayList 的 remove() 方法重载的情况，不要用错方法了。
 * @author wangyu
 * @since 2022/5/28 13:34
 */
public class Solution797 {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), ans, graph, 0, graph.length);
        return ans;
    }

    private static void dfs(List<Integer> ret, List<List<Integer>> ans, int[][] graph, int val, int length) {
        if (val == length - 1) {
            ret.add(val);
            ans.add(new ArrayList<>(ret));
            ret.remove(ret.size() - 1);
            return;
        }
        ret.add(val);
        for(int next : graph[val]) {
            dfs(ret, ans, graph, next, length);
        }
        ret.remove(ret.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}
