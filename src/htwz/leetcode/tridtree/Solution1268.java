package htwz.leetcode.tridtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyu
 * @since 2022/5/25 8:03
 */
public class Solution1268 {

    public static void main(String[] args) {

    }

    class Node {
        Node[] tridNode = new Node[26];
        boolean isWord;
        String product;
        int count;
    }

    Node root = new Node();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(int i = 0; i < products.length; i++) {
            Node p = root;
            addTree(p, products[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 1; i <= searchWord.length(); i++) {
            ans.add(search(searchWord.substring(0, i)));
        }
        return ans;
    }

    private List<String> search(String sub) {
        List<String> ret = new ArrayList<>();
        Node p = root;
        for(char c : sub.toCharArray()) {
            if(p.tridNode[c - 'a'] == null) {
                return ret;
            }
            p = p.tridNode[c - 'a'];
        }
        dfs(p, ret);
        return ret;
    }

    private void dfs(Node root, List<String> ret) {
        if(root.isWord) {
            for(int i = 0; i < root.count; i++) {
                ret.add(root.product);
                if(ret.size() >= 3) {
                    return;
                }
            }

        }
        for(Node node : root.tridNode) {
            if(node != null) {
                dfs(node, ret);
            }
            if(ret.size() >=3) {
                return;
            }
        }
    }

    private void addTree(Node p, String product) {
        for(int i = 0; i < product.length(); i++) {
            int u = product.charAt(i) - 'a';
            if(p.tridNode[u] == null) {
                p.tridNode[u] = new Node();
            }
            p = p.tridNode[u];
        }
        if(!p.isWord) {
            p.isWord = true;
            p.product = product;
        }
        p.count++;
    }
}
