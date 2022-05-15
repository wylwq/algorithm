package htwz.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 n! 的全排列
 *
 * @author wangyu
 * @since 2022/5/15 22:57
 */
public class Solution0 {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[4];
        allPaiLie(ans, sb, visited);
        System.out.println(ans);
    }

    public static void allPaiLie(List<String> ans, StringBuilder sb, boolean[] visited) {
        if (3 == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (!visited[i]) {
                sb.append(i);
                visited[i] = true;
                allPaiLie(ans, sb, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
