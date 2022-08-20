package htwz.leetcode.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 思路：
 * 前言
 * 对于每个滑动窗口，我们可以使用 O(k)O(k) 的时间遍历其中的每一个元素，找出其中的最大值。
 * 对于长度为 nn 的数组 \textit{nums}nums 而言，窗口的数量为 n-k+1n−k+1，
 * 因此该算法的时间复杂度为 O((n-k+1)k)=O(nk)O((n−k+1)k)=O(nk)，会超出时间限制，因此我们需要进行一些优化。
 *
 * 我们可以想到，对于两个相邻（只差了一个位置）的滑动窗口，
 * 它们共用着 k-1k−1 个元素，而只有 11 个元素是变化的。我们可以根据这个特点进行优化。
 *
 * 方法一：优先队列
 * 思路与算法
 *
 * 对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），其中的大根堆可以帮助我们实时维护一系列元素中的最大值。
 *
 * 对于本题而言，初始时，我们将数组 \textit{nums}nums 的前 kk 个元素放入优先队列中。
 * 每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。
 * 然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 \textit{nums}nums 中的位置出现在滑动窗口左边界的左侧。
 * 因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。
 *
 * 我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。此时，堆顶元素就是滑动窗口中的最大值。
 * 为了方便判断堆顶元素与滑动窗口的位置关系，我们可以在优先队列中存储二元组
 * (\textit{num}, \textit{index})(num,index)，表示元素 \textit{num}num 在数组中的下标为 \textit{index}index。
 *
 * @author wangyu
 * @since 2022/8/20 11:35
 */
public class Solution239 {

  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    int[] ints = maxSlidingWindow(nums, k);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] p1, int[] p2) {
        return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
      }
    });
    for (int i = 0; i < k; i++) {
      pq.offer(new int[]{nums[i], i});
    }
    //n个元素对应的滑动窗口的数量
    int[] ans = new int[n - k + 1];
    ans[0] = pq.peek()[0];
    for (int i = k; i < n; i++) {
      pq.offer(new int[]{nums[i], i});
      while (pq.peek()[1] <= i - k) {
        pq.poll();
      }
      ans[i - k + 1] = pq.peek()[0];
    }
    return ans;
  }

}
