package htwz.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author wangyu
 * @since 2023/1/3 23:25
 */
public class Solution119 {

  public static void main(String[] args) {
    List<Integer> row = getRow(3);
    System.out.println(row);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          temp.add(1);
        } else {
          temp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
        }
      }
      ans.add(temp);
    }
    return ans.get(rowIndex);
  }


}
