package htwz.leetcode.queue;

/**
 * 933. 最近的请求次数
 *
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * @author wangyu
 * @since 2022/5/16 11:15
 */
public class Solution933 {

    public static void main(String[] args) {

    }

    int[] ping;
    int front;
    int rear;

    public Solution933() {
        ping = new int[10001];
        front = 0;
        rear = 0;
    }

    public int ping(int t) {
        ping[rear++] = t;
        while(front < rear && ping[front] < t - 3000) {
            front++;
        }
        return rear - front;
    }
}
