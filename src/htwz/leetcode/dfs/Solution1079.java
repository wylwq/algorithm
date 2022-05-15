package htwz.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 1079. 活字印刷
 * 思路：使用 Set 集合进行去重，深度遍历，visited 表示没有走过的下标
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 注意：本题中，每个活字字模只能使用一次。
 *
 * @author wangyu
 * @since 2022/5/15 13:33
 */
public class Solution1079 {

    public static void main(String[] args) {
        String tiles = "AB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[tiles.length()];
        dfs(tiles, sb, visited, ans);
        return ans.size() - 1;
    }

    private static void dfs(String tiles, StringBuilder sb, boolean[] visited, Set<String> ans) {
        ans.add(sb.toString());
        for(int i = 0; i < tiles.length(); i++) {
            if(!visited[i]) {
                sb.append(tiles.charAt(i));
                visited[i] = true;
                dfs(tiles, sb, visited, ans);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
