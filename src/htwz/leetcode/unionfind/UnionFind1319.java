package htwz.leetcode.unionfind;

/**
 * 1319. 连通网络的操作次数
 *
 * 我们可以使用并查集来得到图中的连通分量数。
 * 并查集本身就是用来维护连通性的数据结构。如果其包含 nn 个节点，那么初始时连通分量数为 nn，每成功进行一次合并操作，连通分量数就会减少 11。
 * @author wangyu
 * @since 2022/5/28 11:35
 */
public class UnionFind1319 {

    public int[] parent;

    /**
     * 连通分量大小
     */
    public int count;

    public UnionFind1319(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        parent[rootX] = rootY;
        --count;
        return true;
    }

    private boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
