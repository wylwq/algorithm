package htwz.leetcode.bit;

/**
 * 面试题 16.01. 交换数字
 *
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值
 *
 * @author wangyu
 * @since 2022/9/10 23:11
 */
public class Solution1601 {

  public static void main(String[] args) {
    int[] ints = swapNumbers(new int[]{1, 2});
    System.out.println(ints[0] + " " + ints[1]);
  }

  public static int[] swapNumbers(int[] numbers) {
    numbers[0] = numbers[0] ^ numbers[1];
    numbers[1] = numbers[0] ^ numbers[1];
    numbers[0] = numbers[0] ^ numbers[1];
    return numbers;
  }

}
