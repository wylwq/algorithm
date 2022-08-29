package htwz.leetcode.segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. 我的日程安排表 II
 *
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
 * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * @author wangyu
 * @since 2022/8/29 23:22
 */
public class Solution731 {

  public static void main(String[] args) {

  }

  private List<int[]> books;
  private List<int[]> overlaps;

  public Solution731() {
    books = new ArrayList<>();
    overlaps = new ArrayList<>();
  }

  /**
   * 1. 对于两个区间 [s1, e1) 和 [s2, e2), 如果二者没有交集，则此时应当满足 s1 >= e2 或者 s2 >= e1,
   * 就意味着如果满足 s1 < e2 并且 s2 < e1时，则二者会产生差集
   * 2. 二者的交集为[max(s1, s2),min(e1, e2))
   */
  public boolean book(int start, int end) {
    for (int[] book : overlaps) {
      int l = book[0], r = book[1];
      if (l < end && start < r) {
        return false;
      }
    }
    for (int[] book : books) {
      int l = book[0], r = book[1];
      if (l < end && start < r) {
        overlaps.add(new int[]{Math.max(start, l), Math.min(end, r)});
      }
    }
    books.add(new int[]{start, end});
    return true;
  }

}
