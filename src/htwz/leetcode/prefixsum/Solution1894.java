package htwz.leetcode.prefixsum;

/**
 * 1894. 找到需要补充粉笔的学生编号
 *
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，
 * 以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 *
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。
 * 当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。
 * 如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 *
 * 请你返回需要 补充 粉笔的学生 编号 。
 *
 * @author wangyu
 * @since 2022/8/9 22:27
 */
public class Solution1894 {

    public static void main(String[] args) {
        int[] chalk = {22,86,96,35,62,69,56,33,95,10,38,53,33,90,29,68,85,58,11,49,81,18,32,96,40,75,49,26,60,71,15,94,31,99,12,81,10,19,7,73,35,56,100,15,37,89,58,17,55,62,4,30,68,68,89,62,39,35,16,18,63,73,100,22,46,58,80,77,23,5,52,96,98,21,33,86,81,71,69,72,71,58,17,85,70,22,84,94,75,51,60,81,12,22,13,33,53,58
        };
        int k = 134221332;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        k %= sum;
        sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (k < sum) {
                return i;
            }
        }
        return -1;
    }
}
