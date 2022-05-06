package htwz.leetcode;

/**
 * 滑动窗口---爱生气的书店老板
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * @author wangyu
 * @since 2022/5/7 6:25
 */
public class Solution1052 {

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int satisfied = maxSatisfied(customers, grumpy, minutes);
        System.out.println(satisfied);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        for(int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0) {
                result = result + customers[i];
                customers[i] = 0;
            }
        }
        int maxVal = customers[0];
        int curVal = customers[0];
        //经典滑动窗口，后面加一个，前面减去一个，中间相同部分的内容不发生改变，
        //普通滑动窗口，每次都要重新计算窗口大小的内容，这样导致会重复计算一分部内容
        for(int i = 1; i < customers.length; i++) {
            if(i < minutes) {
                curVal = curVal + customers[i];
            } else {
                curVal = curVal + customers[i] - customers[i - minutes];
            }
            maxVal = Math.max(maxVal, curVal);
        }
        return (result + maxVal);
    }
}
