package htwz.line.stack;
/**
* @author: wy
* @createDate: 2020/3/8/008 11:50
* @descption 用栈完成计算表达式的计算,后缀表达式,只支持单位数计算
* @version: 1.0.0
*/
public class Calculator {

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        //创建两个栈，数字栈与符号栈
        ArrayStackV2<Integer> numStatck = new ArrayStackV2<>(20);
        ArrayStackV2<Character> operStatck = new ArrayStackV2<>(20);
        int index = 0, num1, num2, res;
        int oper;
        char ch;
        while (true) {
            //依次得到计算表达式的每个字符
            ch = expression.substring(index, index+1).charAt(0);
            if (operStatck.isOper(ch)) {
                //判断当前符号栈是否为空,如果为空直接入栈
                if (!operStatck.isEmpty()) {
                    //如果符号栈中有符号，优先级低的话就进行计算，否则就进行入栈操作
                    if (operStatck.priority(ch) <= operStatck.priority(operStatck.peek())) {
                        num1 = numStatck.pop();
                        num2 = numStatck.pop();
                        oper = operStatck.pop();
                        res = numStatck.cal(num1, num2, oper);
                        operStatck.push(ch);
                        numStatck.push(res);
                    } else {
                        operStatck.push(ch);
                    }
                } else {
                    operStatck.push(ch);
                }
            } else {
                //如果是数，直接入栈
                numStatck.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //表达式扫描完毕后，就进行顺序的从数字栈与符号栈中的数字弹出并计算
        while(true) {
            if (operStatck.isEmpty()) {
                break;
            }
            num1 = numStatck.pop();
            num2 = numStatck.pop();
            oper = operStatck.pop();
            res = numStatck.cal(num1, num2, oper);
            numStatck.push(res);
        }
        System.out.printf("表达式%s=%d", expression, numStatck.pop());
    }

}

class ArrayStackV2<T> {

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

    public ArrayStackV2() {
        this(DEFAULT_SIZE);
    }

    public ArrayStackV2(int maxSize) {
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

    /**
     * 返回运算符的优先级，
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }
        if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }

    /**
     * 判断是不是运算符
     * @param oper
     * @return
     */
    public boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 计算方法,注意除法与减法数字的先后顺序
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num1 != 0) {
                    res = num2 / num1;
                } else {
                    System.out.println("除数不能为零");
                    System.exit(0);
                }
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 计算方法,注意除法与减法数字的先后顺序
     */
    public Long calV2(Long num1, Long num2, int oper) {
        Long res = 0L;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num1 != 0) {
                    res = num2 / num1;
                } else {
                    System.out.println("除数不能为零");
                    System.exit(0);
                }
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 返回当前栈顶的元素
     * @return
     */
    public T peek() {
        return (T) stack[top];
    }

}