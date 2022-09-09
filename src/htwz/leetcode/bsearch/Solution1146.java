package htwz.leetcode.bsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1146. 快照数组
 *
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 *
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 *
 * @author wangyu
 * @since 2022/9/9 22:40
 */
public class Solution1146 {

  Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

  int size = 0;

  public Solution1146(int length) {
    while (length-- > 0) {
      TreeMap<Integer, Integer> m = new TreeMap<>();
      m.put(0, 0);
      map.put(length, m);
    }
  }

  public void set(int index, int val) {
    TreeMap<Integer, Integer> m = map.get(index);
    m.put(size, val);
  }

  public int snap() {
    return size++;
  }

  public int get(int index, int snap_id) {
    TreeMap<Integer, Integer> m = map.get(index);
    return m.floorEntry(snap_id).getValue();
  }

}
