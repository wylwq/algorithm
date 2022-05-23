package htwz.leetcode.tridtree;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * @author wangyu
 * @since 2022/5/24 0:02
 */
public class Solution211 {

    public static void main(String[] args) {

    }

    class Node {
        Node[] tridNode = new Node[26];
        boolean isWord;
    }
    Node root = new Node();
    public void addWord(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tridNode[u] == null) p.tridNode[u] = new Node();
            p = p.tridNode[u];
        }
        p.isWord = true;
    }
    public boolean search(String s) {
        return dfs(s, root, 0);
    }
    boolean dfs(String s, Node p, int level) {
        int n = s.length();
        if (n == level) {
            return p.isWord;
        }
        char c = s.charAt(level);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (p.tridNode[j] != null && dfs(s, p.tridNode[j], level + 1)){
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            if (p.tridNode[index] == null) {
                return false;
            }
            return dfs(s, p.tridNode[index], level + 1);
        }
    }
}
