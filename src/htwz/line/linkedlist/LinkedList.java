package htwz.line.linkedlist;

import java.util.Stack;

/**
* @author: wy
* @createDate: 2020/1/10/010 22:45
* @descption
* @version: 1.0.0
*/
public class LinkedList {

    private Node head = new Node(0);

    /**
     * 添加新节点
     * @param node
     */
    public void add(Node node) {
        Node tempNode = this.head;
        //遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (tempNode.next == null) {
                break;
            }
            //没有找到，temp就下移动一个节点
            tempNode = tempNode.next;
        }
        tempNode.next = node;
    }

    /**
     * 遍历链表
     */
    public void forEach() {
        //判断链表是否为null
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node tempNode = head.next;
        while (true) {
            if (tempNode == null) {
                break;
            }
            System.out.println(tempNode.toString());
            tempNode = tempNode.next;
        }
    }

    /**
     * 对添加的节点进行排序
     */
    public void addSort(Node node) {
        Node tempNode = this.head;
        boolean flag = false;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            if (tempNode.next.no > node.no) {
                break;
            }
            if (tempNode.next.no == node.no) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            System.out.println("节点已经存在添加失败~");
        } else {
            node.next = tempNode.next;
            tempNode.next = node;
        }
    }

    /**
     * 链表反转
     * 思路：使用头插法,腾讯面试题
     */
    public void reserve(Node headNode) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        //定义一个辅助的指针
        Node cur = headNode.next;
        Node next;
        Node reverseNode = new Node(0);
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面有用
            cur.next = reverseNode.next;//将cur的下一个节点指向新的链表的最前端
            reverseNode.next = cur;//将新节点的下一个节点只想当前节点
            cur = next;//当前节点向下挪动一个位置
        }
        headNode.next = reverseNode.next;
    }

    /**
     * 逆序遍历链表
     */
    public void reserveList(Node headNode) {
        if (headNode.next == null) {
            return;
        }
        Node node = headNode.next;
        Stack<Node> stack = new Stack<>();
        while (node != null) {

            stack.push(node);
            node = node.next;
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.pop().no);
        }
    }
}

class Node {

    public int no;

    public Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "no = " + no;
    }
}
