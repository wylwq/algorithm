package htwz.leetcode.linked;

import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为 n 的链表 head
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 *
 *
 * @author wangyu
 * @since 2022/5/12 21:58
 */
public class Solution1019 {

    public static void main(String[] args) {
        nextLargerNodes(null);
    }

    public static int[] nextLargerNodes(ListNode head) {
        int[] tmp = new int[10001];
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        int i = 0, j = 0;
        while(curr != null) {
            while(!stack.isEmpty() && curr.val > stack.peek()) {
                stack.pop();
                tmp[--j] = curr.val;
            }
            stack.push(curr.val);
            tmp[i++] = 0;
            j = i;
            curr = curr.next;
        }
        int[] ans = new int[i];
        for(int k = 0; k < i; k++) {
            ans[k] = tmp[k];
        }
        return ans;
    }
}
