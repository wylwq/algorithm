package htwz.leetcode.queue;

/**
 * @author wangyu
 * @since 2022/5/16 11:55
 */
public class Solution641 {

    public static void main(String[] args) {

    }

    int[] elements;
    int size;

    public Solution641(int k) {
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
