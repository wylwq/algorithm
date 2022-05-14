package htwz.leetcode.stack;

/**
 * 1381. 设计一个支持增量操作的栈
 *
 * 请你设计一个支持下述操作的栈。
 * 实现自定义栈类 CustomStack ：
 *
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 *  
 *
 * @author wangyu
 * @since 2022/5/14 23:58
 */
public class Solution1381 {

    private final int maxSize;
    private final int[] customs;
    private int point;

    public Solution1381(int maxSize) {
        this.maxSize = maxSize;
        point = 0;
        customs = new int[maxSize + 1];
    }

    public void push(int x) {
        if (point >= maxSize) {
            return;
        }
        customs[point++] = x;
    }

    public int pop() {
        if (point <= 0) {
            return -1;
        }
        return customs[--point];
    }

    public void increment(int k, int val) {
        if (k > point) {
            k = point;
        }
        for (int i = 0; i < k; i++) {
            customs[i] = customs[i] + val;
        }
    }
}
