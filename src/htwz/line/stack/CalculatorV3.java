package htwz.line.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @author: wy
* @createDate: 2020/3/10/010 0:05
* @descption 使用逆波兰表达式进行计算,支持小数点和括号
* @version: 1.0.0
*/
public class CalculatorV3 {

    public static void main(String[] args) {
        String infixExpression = "1+((2+3)*4)-5";
        System.out.println("中缀表达式:"+infixToList(infixExpression));
        //3.将得到的中缀表达式转换为后缀表达式
        System.out.println("后缀表达式:"+parseInfixToPrefix(infixToList(infixExpression)));
        System.out.println("后缀表达式结果:"+calculate(parseInfixToPrefix(infixToList(infixExpression))));
    }

    /**
     *
     * @param suffixExpression
     * @return
     */
    private static <T> List<T> getListString(String suffixExpression, List<T> list) {
        T[] split = (T[]) suffixExpression.split(" ");
        for(T element : split) {
            list.add(element);
        }
        return list;
    }

    private static List<String> infixToList(String expression) {
        List<String> infix = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        while (index < expression.length()) {

            char c = expression.charAt(index);
            if (c < 48 || c > 57) {
                infix.add(String.valueOf(c));
                index++;
            } else {
                while (index < expression.length() && (expression.charAt(index) > 48 && expression.charAt(index) <57)) {
                    stringBuffer.append(expression.charAt(index));
                    index++;
                }
                infix.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            }
        }
        return infix;
    }

    /**
     * 完成对逆波兰表达式的计算
     */
     public static int calculate(List<String> ls) {
         Stack<String> stack = new Stack<>();
         for (String string : ls) {
             //这里用正则表达式来取数
             if (string.matches("\\d+")) {
                 stack.push(string);
             } else {
                 int num2 = Integer.parseInt(stack.pop());
                 int num1 = Integer.parseInt(stack.pop());
                 int res;
                 if (string.equals("+")) {
                     res = num1 + num2;
                 } else if (string.equals("-")) {
                     res = num1 - num2;
                 } else if (string.equals("*")) {
                     res = num1 * num2;
                 } else if (string.equals("/")) {
                     res = num1 / num2;
                 } else {
                     throw new RuntimeException("运算符异常");
                 }
                 stack.push(res + "");
             }
         }
         return Integer.parseInt(stack.pop());
     }

    /**
     * infix -> prefix
     */
    public static List<String> parseInfixToPrefix(List<String> ls) {
        Stack<String> operStack = new Stack<>();
        //Stack<String> stack = new Stack<>();
        //说明：因为stack这个栈在整个转换过程中，没有pop操作，而且后面我们还要逆序输出
        //因此，可以直接使用List<String>
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            //如果是一个数，入栈
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                operStack.add(item);
            } else if (item.equals(")")) {
                while (!operStack.peek().equals("(")) {
                    s2.add(operStack.pop());
                }
                //消除小括号
                operStack.pop();
            } else {
                //但operStack的优先级小于或者等于栈顶运算符，将s1栈顶的运算符弹出加入到s2中,重复上面的动作
                while (operStack.size() != 0 && Operation.getValue(operStack.peek()) >= Operation.getValue(item)) {
                    s2.add(operStack.pop());
                }
                //还需要将item压入符号栈
                operStack.push(item);
            }
        }
        //将是剩下的运算符依次弹出加入到s2中
        while (operStack.size() != 0) {
            s2.add(operStack.pop());
        }
        return s2;
    }


}

/**
 * 编写运算符优先级的方法
 */
class Operation {

    private static int ADD = 1;

    private static int SUB = 1;

    private static int MUL = 2;

    private static int DIV = 2;

    public static  int getValue(String operatoin) {
        int result = 0;
        switch (operatoin) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
        }
        return result;
    }
}


