package htwz.line.stack;


import java.util.Scanner;

/**
* @author: wy
* @createDate: 2020/1/18/018 18:52
* @descption 使用数组模拟栈
* @version: 1.0.0
*/
public class ArrayStack<T> {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加元素到站栈中");
            System.out.println("pop:栈取出元素");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.forEach();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int element = scanner.nextInt();
                    arrayStack.push(element);
                    break;
                case "pop":
                    int res = arrayStack.pop();
                    System.out.println(res);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~");
    }

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 栈的默认大小
     */
    private static final int DEFAULT_SIZE = 3;

    /**
     * 数组模拟栈
     */
    private Object[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 向栈顶添加元素
     * @param element
     */
    public void push(T element) {
        if (isFull()) {
            System.out.println("栈满~");
            return;
        }
        top++;
        stack[top] = element;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("栈空~");
            return null;
        }
        return (T) stack[top--];
    }

    /**
     * 遍历栈
     */
    public void forEach() {
        if (isEmpty()) {
            System.out.println("栈空~");
            return;
        }
        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
