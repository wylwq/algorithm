package htwz.leetcode.queue;

/**
 * @author wangyu
 * @since 2022/5/16 18:04
 */
public class Solution1670 {

    public static void main(String[] args) {
        Solution1670 q = new Solution1670();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        q.pushMiddle(5);  // [1, 3, 2]
        q.popFront();     // 返回 1 -> [4, 3, 2]
        q.popMiddle();    // 返回 3 -> [4, 2]
        q.popMiddle();    // 返回 4 -> [2]
        q.popBack();      // 返回 2 -> []
        q.popFront();     // 返回 -1 -> [] （队列为空）
    }

    int[] elements;
    int size;

    public Solution1670() {
        elements = new int[1001];
        size = 0;
    }

    public void pushFront(int val) {
        for(int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0]=val;
        size++;
    }

    public void pushMiddle(int val) {
        int mid = size / 2;
        for(int i = size; i > mid; i--) {
            elements[i] = elements[i - 1];
        }
        elements[mid] = val;
        size++;
    }

    public void pushBack(int val) {
        elements[size] = val;
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int front = elements[0];
        for(int i = 0; i < size; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return front;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        int mid = size % 2 == 0 ? size / 2 - 1 : size / 2;
        int midVal = elements[mid];
        for(int i = mid; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return midVal;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        int back = elements[size-1];
        size--;
        return back;
    }
}