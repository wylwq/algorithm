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

    int[] elements;
    int size;

    public Solution933(int k) {
        elements = new int[k];
    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        for(int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        elements[size] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        for(int i = 0; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        elements[size - 1] = 0;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return elements[0];
    }

    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return elements.length == size;
    }
}
