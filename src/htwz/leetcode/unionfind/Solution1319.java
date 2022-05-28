package htwz.leetcode.unionfind;

/**
 * @author wangyu
 * @since 2022/5/28 11:32
 */
public class Solution1319 {

    public static int makeConnected(int n, int[][] connections) {
        UnionFind1319 uf = new UnionFind1319(n);
        if (connections.length < n - 1) {
            return -1;
        }
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        //减一是因为 如果有n个连通分量，则只需要n - 1 根线即可完成连通
        return uf.count - 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] parent = {{0,1},{0,2},{1,2}};
        int connected = makeConnected(n, parent);
        System.out.println(connected);
    }
}
