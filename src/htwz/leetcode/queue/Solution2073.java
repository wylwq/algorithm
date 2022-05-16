package htwz.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2073. 买票需要的时间
 *
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，
 * 如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 *
 * @author wangyu
 * @since 2022/5/16 11:30
 */
public class Solution2073 {

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        Queue<Ticket> queue = new ArrayDeque<>();
        for(int i = 0; i < tickets.length; i++) {
            Ticket t = new Ticket();
            t.ticket = tickets[i];
            t.pos = i;
            queue.add(t);
        }
        while(!queue.isEmpty()) {
            Ticket ticket = queue.remove();
            ticket.ticket = ticket.ticket - 1;
            ans++;
            if (ticket.ticket > 0) {
                queue.add(ticket);
            } else {
                if (ticket.pos == k) {
                    return ans;
                }
            }
        }
        return ans;

    }
}
//2 3 2
//3 2 1
//2 1 2
//1 2 1
//2 1
//1 1
//1
class Ticket {
    public Integer ticket;
    public Integer pos;
}
