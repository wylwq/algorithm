package htwz.leetcode.dubbleLinked;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @author wangyu
 * @since 2022/5/13 23:43
 */
public class Solution036 {

    public static void main(String[] args) {

    }

    private Map<Integer, Node> map = new HashMap<>();
    private Integer count = 0;

    public Node treeToDoublyList(Node root) {
        recursion(root);
        for (int i = 0; i < count; i++) {
            if(i == count - 1) {
                map.get(i).right = map.get(0);
            } else {
                map.get(i).right = map.get(i + 1);
            }
            if(i == 0) {
                map.get(i).left = map.get(count - 1);
            } else {
                map.get(i).left = map.get(i - 1);
            }
        }
        return map.get(0);
    }

    private void recursion(Node node) {
        if(node == null) {
            return;
        }
        recursion(node.left);
        map.put(count++, node);
        recursion(node.right);
    }
}