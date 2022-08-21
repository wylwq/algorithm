package htwz.leetcode.bfs;

import java.util.List;

/**
 * @author wangyu
 * @since 2022/8/21 22:57
 */
public class Employee {

  public int id;
  public int importance;
  public List<Integer> subordinates;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getImportance() {
    return importance;
  }

  public void setImportance(int importance) {
    this.importance = importance;
  }

  public List<Integer> getSubordinates() {
    return subordinates;
  }

  public void setSubordinates(List<Integer> subordinates) {
    this.subordinates = subordinates;
  }

}
