package htwz.leetcode.stack;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 * 就不可能是该压栈序列的弹出序列。
 *
 * @author wangyu
 * @since 2022/8/17 6:48
 */
public class Solution31 {

  public static void main(String[] args) {
    int[] pushed = {1,2,3,4,5};
    int[] popped = {4,5,3,2,1};
    boolean b = validateStackSequences(pushed, popped);
    System.out.println(b);
  }

  public static boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> p = new Stack<>();
    int i = 0, j = 0;
    while (i < pushed.length || j < popped.length) {
      p.push(pushed[i++]);
      while (!p.isEmpty() && popped[j] == p.peek()) {
        p.pop();
        j++;
      }
      if (i == pushed.length && j < popped.length) {
        return false;
      }
    }
    return true;
  }

}
