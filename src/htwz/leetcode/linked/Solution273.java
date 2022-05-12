package htwz.leetcode.linked;

/**
 * 237. 删除链表中的节点
 *
 * 思路：将下一个节点的val 复制给当前节点，将下一个节点的地址赋值给当前节点
 *
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 *
 * @author wangyu
 * @since 2022/5/12 22:02
 */
public class Solution273 {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
