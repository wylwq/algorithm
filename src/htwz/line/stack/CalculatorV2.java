package htwz.line.stack;
/**
 * @author: wy
 * @createDate: 2020/3/8/009 11:50
 * @descption 用栈完成计算表达式的计算,后缀表达式,可支持多位数计算
 * @version: 1.0.0
 */
public class CalculatorV2 {

    public static void main(String[] args) {
        String expression = "3+1/100-2";
        //创建两个栈，数字栈与符号栈
        ArrayStackV2<String> numStatck = new ArrayStackV2<>(20);
        ArrayStackV2<Character> operStatck = new ArrayStackV2<>(20);
        StringBuffer sb = new StringBuffer();
        int index = 0, oper;
        long res, num1, num2;
        char ch;
        while (true) {
            //依次得到计算表达式的每个字符
            ch = expression.substring(index, index+1).charAt(0);
            //判断ch的类型，然后做相应的处理
            if (operStatck.isOper(ch)) {
                //判断当前符号栈是否为空,如果为空直接入栈
                if (!operStatck.isEmpty()) {
                    //如果符号栈中有符号，优先级低就进行计算，优先级高就进行入栈操作
                    if (operStatck.priority(ch) <= operStatck.priority(operStatck.peek())) {
                        num1 = Long.valueOf(numStatck.pop());
                        num2 = Long.valueOf(numStatck.pop());
                        oper = operStatck.pop();
                        res = numStatck.calV2(num1, num2, oper);
                        operStatck.push(ch);
                        numStatck.push(String.valueOf(res));
                    } else {
                        operStatck.push(ch);
                    }
                } else {
                    operStatck.push(ch);
                }
            } else {
                //如果是数，直接入栈
                sb.append(ch);
                while(true) {
                    index++;
                    if (index >= expression.length()) {
                        break;
                    }
                    char isNumCh = expression.substring(index, index+1).charAt(0);
                    if (operStatck.isOper(isNumCh)) {
                        index--;
                        break;
                    }
                    sb.append(isNumCh);
                }
                numStatck.push(sb.toString());
                sb.setLength(0);
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
            num1 = Long.valueOf(numStatck.pop());
            num2 = Long.valueOf(numStatck.pop());
            oper = operStatck.pop();
            res = numStatck.calV2(num1, num2, oper);
            numStatck.push(String.valueOf(res));
        }
        System.out.printf("表达式%s=%s", expression, numStatck.pop());
    }

}