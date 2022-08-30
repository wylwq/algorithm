package htwz.leetcode.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.07. 婴儿名字
 *
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，
 * 也就是同名婴儿的数量。有些名字有多种拼法，
 * 例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
 * 给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
 * 设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，
 * 并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 *
 * 在结果列表中，选择 字典序最小 的名字作为真实名字。
 *
 * @author wangyu
 * @since 2022/8/30 22:14
 */
public class Solution1707 {

  public static void main(String[] args) {
    String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
    String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
    System.out.println(trulyMostPopular(names, synonyms));
  }

  private static Map<String, String> map = new HashMap<>();

  public static String[] trulyMostPopular(String[] names, String[] synonyms) {
    Map<String, Integer> cnt = new HashMap<>();
    //初始化并查集元素
    for (String name : names) {
      int nIdx = name.indexOf("(");
      map.put(name.substring(0, nIdx), name.substring(0, nIdx));
    }
    //1. 连通的并查集合并操作
    for (String synonym : synonyms) {
      String[] temp = synonym.split(",");
      String x = temp[0].substring(1);
      String y = temp[1].substring(0, temp[1].length() - 1);
      if (!map.containsKey(x)) {
        map.put(x, x);
      }
      if (!map.containsKey(y)) {
        map.put(y, y);
      }
      //获取两个集合的根
      String fx = find(x);
      String fy = find(y);

      //合并两个并查集,将字段序小的作为新的根
      if (!fx.equals(fy)) {
        if (fx.compareTo(fy) > 0) {
          map.put(fx, fy);
        } else {
          map.put(fy, fx);
        }
      }
    }
    //2. 计数
    for (String name : names) {
      int nIdx = name.indexOf("(");
      //将数值都累加到根的位置
      String root = find(name.substring(0, nIdx));
      cnt.put(root, cnt.getOrDefault(root, 0) +
          Integer.parseInt(name.substring(nIdx + 1, name.length() - 1)));
    }
    List<String> ans = new ArrayList<>();
    //3. 输出答案
    for (String name : names) {
      int nIdx = name.indexOf("(");
      String root = find(name.substring(0, nIdx));
      //只输出根
      if (!root.equals(name.substring(0, nIdx))) {
        continue;
      }
      ans.add(root + "(" + String.valueOf(cnt.get(root)) + ")");
    }
    return ans.toArray(new String[0]);
  }

  //查根
  private static String find(String x) {
    if (!map.get(x).equals(x)) {
      map.put(x, find(map.get(x)));
    }
    return map.get(x);
  }

}
