package htwz.line.ringqueue;

import java.util.Objects;

/**
* @author: wy
* @createDate: 2020/1/9/009 11:48
* @descption java模拟循环队列
* @version: 1.0.0
*/
public class RingQueuey<T> {

    /**
     * 队列的最大长度
     */
    private Integer maxSize;

    /**
     * 队列容器
     */
    private Object[] ringArray;

    /**
     * 队列头指针
     */
    private Integer front;

    /**
     * 队列尾指针
     */
    private Integer rear;

    /**
     * 队列初始化长度
     */
    private static final Integer INITSIZE = 5;

    public RingQueuey() {
        this(INITSIZE);
    }

    public RingQueuey(Integer maxSize) {
        this.maxSize = maxSize + 1;
        ringArray = new Object[this.maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public  boolean isEmpty() {
        return Objects.equals(front, rear);
    }

    /**
     * 添加元素
     */
    public void offset(T element) {
        if (isFull()) {
            System.out.println("队列已满，添加失败~");
        } else {
            ringArray[rear] = element;
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 取出队头元素
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T temp = (T) ringArray[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 获取对头元素
     * @return
     */
    public T peak() {
        if (isEmpty()) {
           return null;
        }
        return (T) ringArray[front];
    }

    /**
     * 遍历数组
     */
    public void forEach() {
        for (int i = front; i < front + size(); i++) {
            System.out.println(ringArray[i % maxSize]);
        }
    }

    /**
     * 有效元素个数
     * @return
     */
    public Integer size() {
        return (rear + maxSize - front) % maxSize;
    }
}
