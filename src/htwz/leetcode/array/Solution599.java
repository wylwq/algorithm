package htwz.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. 两个列表的最小索引总和
 *
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，
 * 每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，
 * 则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 *
 * @author wangyu
 * @since 2022/9/1 23:44
 */
public class Solution599 {

  public static void main(String[] args) {

  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      index.put(list1[i],  i);
    }
    List<String> ans = new ArrayList<>();
    int indexSum = Integer.MAX_VALUE;
    for (int i = 0; i < list2.length; i++) {
      if (i > indexSum) {
        break;
      }
      if (index.containsKey(list2[i])) {
        Integer j = index.get(list2[i]);
        if (i + j < indexSum) {
          ans.clear();
          ans.add(list2[i]);
          indexSum = i + j;
        } else if(i + j == indexSum) {
          ans.add(list2[i]);
        }
      }
    }
    return ans.toArray(new String[0]);
  }

}
