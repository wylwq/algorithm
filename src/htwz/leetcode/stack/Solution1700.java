package htwz.leetcode.stack;

import java.util.*;

/**
 * 无法吃午餐的学生数量
 *
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组 students 和 sandwiches ，
 * 其中 sandwiches[i] 是栈里面第 i​​​​​​ 个三明治的类型（i = 0 是栈的顶部），
 *  students[j] 是初始队列里第 j​​​​​​ 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 *
 * @author wangyu
 * @since 2022/5/14 23:15
 */
public class Solution1700 {

    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.add(sandwiches[i]);
            queue.add(students[students.length - 1 - i]);
        }
        int cycle;
        boolean end = false;
        while (!end && !stack.isEmpty()) {
            Integer sandwich = stack.pop();
            cycle = 0;
            for (int i = 0; i < queue.size(); i++) {
                Integer student = queue.poll();
                cycle++;
                if (student == sandwich) {
                    break;
                }
                queue.addLast(student);
                if (cycle >= queue.size()) {
                    end = true;
                    break;
                }
            }
        }
        return queue.size();
    }


}
