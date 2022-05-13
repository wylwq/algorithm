package htwz.leetcode.dubbleLinked;

/**
 * @author wangyu
 * @since 2022/5/13 23:52
 */
public class Solution430 {

    public static void main(String[] args) {

    }

    public Node last = null;
    public Node flatten(Node head) {
        if (head == null) return null;
        Node next = head.next;
        if(last != null) {
            //将下一个节点和上一个节点连接起来，有点像线索二叉树
            last.next = head;
            head.prev = last;
            last.child = null;
        }
        //记住上一个节点
        last = head;
        //根据题意,应该先递归子节点，子节点递归结束在递归下一个节点
        flatten(head.child);
        //递归下一个节点
        flatten(next);
        return head;
    }
}
