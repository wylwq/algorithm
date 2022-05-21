package htwz.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 1792. 最大平均通过率
 * 思路: 使用 java 的优先队列 priorityQueue, 自定义排序策略, 同时也是用贪心策略
 *
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，
 * 其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，
 * 其中只有 passi 个学生可以通过考试。
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，
 * 他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 *
 * @author wangyu
 * @since 2022/5/21 23:16
 */
public class Solution1792 {

    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3,5}, {2,2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        // 定义优先队列，优先级按照增加 1 名学生之后能够产生的最大贡献来排序
        PriorityQueue<double[]> queue = new PriorityQueue<double[]>((o1, o2) -> {

            double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });

        // 转化为 double，方便小数计算
        for (int[] c : classes) {

            queue.offer(new double[]{c[0], c[1]});
        }

        // 分配学生，每次分配 1 名
        while (extraStudents > 0) {

            double[] maxClass = queue.poll(); //取出能够产生最大影响的班级
            maxClass[0] += 1.0; //通过的人数
            maxClass[1] += 1.0; //班级总人数

            queue.offer(maxClass); //将更新后的重新加入队列中
            extraStudents--;
        }

        // 计算最终结果
        double res = 0;
        while (!queue.isEmpty()) {

            double[] c = queue.poll();
            res += (c[0] / c[1]);
        }
        return res / n;
    }


}
