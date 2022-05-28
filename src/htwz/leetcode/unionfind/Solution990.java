package htwz.leetcode.unionfind;

/**
 * 990. 等式方程的可满足性
 * 思路：使用一个数组 parent 存储每个变量的连通分量信息，其中的每个元素表示当前变量所在的连通分量的父节点信息，
 * 如果父节点是自身，说明该变量为所在的连通分量的根节点。一开始所有变量的父节点都是它们自身，对于合并操作，我们将
 * 第一个变量的根节点的父节点指向第二个变量的根节点；对于查找操作，我们沿着当前变量的父节点一路向上查找，直到找到根节点
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 * @author wangyu
 * @since 2022/5/28 7:09
 */
public class Solution990 {

    public boolean equationsPossible(String[] equations) {
        UnionFind990 uf = new UnionFind990(26);

        for(String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '=') {
                int x = chars[0] - 'a';
                int y = chars[3] - 'a';
                uf.union(x, y);
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                int x = chars[0] - 'a';
                int y = chars[3] - 'a';
                if (uf.isConnected(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b","b!=a"};
        Solution990 s = new Solution990();
        boolean b = s.equationsPossible(equations);
        System.out.println(b);
    }
}
