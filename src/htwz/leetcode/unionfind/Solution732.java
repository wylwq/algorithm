package htwz.leetcode.unionfind;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表 III
 *
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 *
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，
 * 表示所有先前日程安排会产生的最大 k 次预订。
 *
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 *
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *
 * @author wangyu
 * @since 2022/8/26 23:53
 */
public class Solution732 {

  public static void main(String[] args) {

  }

  private TreeMap<Integer, Integer> cnt;

  public Solution732() {
    cnt = new TreeMap<>();
  }

  public int book(int start, int end) {
    int ans = 0;
    int maxBook = 0;
    cnt.put(start, cnt.getOrDefault(start, 0) + 1);
    cnt.put(end, cnt.getOrDefault(end, 0) - 1);
    for (Entry<Integer, Integer> entry : cnt.entrySet()) {
      Integer freq = entry.getValue();
      maxBook += freq;
      ans = Math.max(maxBook, ans);
    }
    return ans;
  }

}
