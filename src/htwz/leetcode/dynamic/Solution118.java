package htwz.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author wangyu
 * @since 2023/1/2 23:45
 */
public class Solution118 {

  public static void main(String[] args) {
    List<List<Integer>> generate = generate(3);
    for (List<Integer> list : generate) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    for(int i = 0; i < numRows; ++i) {
      List<Integer> row = new ArrayList<Integer>();
      for(int j = 0; j <= i; j++) {
        if(j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
        }
      }
      ret.add(row);
    }
    return ret;
  }

}
