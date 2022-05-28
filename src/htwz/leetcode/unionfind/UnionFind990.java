package htwz.leetcode.unionfind;

/**
 * @author wangyu
 * @since 2022/5/28 7:10
 */
public class UnionFind990 {

    private int[] parent;

    public UnionFind990(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
