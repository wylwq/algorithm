package htwz.leetcode.dubbleLinked;

/**
 * @author wangyu
 * @since 2022/5/13 23:44
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
