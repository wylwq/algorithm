package htwz.leetcode.heap;

import java.util.Arrays;

/**
 * 2285. 道路的最大总重要性
 *
 * 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 *
 * 给你一个二维整数数组 roads ，
 * 其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 
 * 之间有一条 双向 道路。
 *
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。
 * 道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 *
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 *
 * @author wangyu
 * @since 2022/8/25 23:48
 */
public class Solution2285 {

  public static void main(String[] args) {
    int n = 5;
    int[][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
    System.out.println(maximumImportance(n, roads));
  }

  public static long maximumImportance(int n, int[][] roads) {
    int count[]=new int[n];
    for(int i=0;i<roads.length;i++){
      count[roads[i][0]]++;
      count[roads[i][1]]++;
    }
    Arrays.sort(count);
    long ans=0;
    for(int i=0;i<n;i++){ans+=(long)(i+1)*count[i];}
    return ans;
  }

}
