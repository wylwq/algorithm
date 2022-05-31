package htwz.leetcode.tuoposort;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 207. 课程表
 *
 * 思路：统计每门课程需要学习的前置课程数量，先学完不需要前置课程的课，然后需要学到前置课程相关的课数减一，当减为0时，那么就可以学习该课程
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @author wangyu
 * @since 2022/5/30 16:39
 */
public class Solution207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for(int[] p : prerequisites) {
            in[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int[] p : prerequisites) {
                if (p[1] == poll) {
                    in[p[0]]--;
                    if (in[p[0]] == 0) {
                        q.add(p[0]);
                    }
                }
            }
        }
        boolean ans = true;
        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        //int[][] prerequisites = {{1, 0}};
        int[][] prerequisites = {{1,0},{0,1}};
        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }
}
