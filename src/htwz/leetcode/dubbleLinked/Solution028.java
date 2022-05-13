package htwz.leetcode.dubbleLinked;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 *
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 * @author wangyu
 * @since 2022/5/13 23:46
 */
public class Solution028 {

    public static void main(String[] args) {

    }

    public Node last = null;
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        if(last != null) {
            last.next = head;
            head.prev = last;
            last.child = null;
        }
        Node next = head.next;
        last = head;
        flatten(head.child);
        flatten(next);
        return head;
    }
}
