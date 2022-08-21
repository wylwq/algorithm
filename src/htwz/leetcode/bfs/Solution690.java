package htwz.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690. 员工的重要性
 *
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
 * 那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
 * 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 * @author wangyu
 * @since 2022/8/21 22:56
 */
public class Solution690 {

  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    Employee e1 = new Employee();
    e1.setId(1);
    e1.setImportance(5);
    List<Integer> sb = new ArrayList<>();
    sb.add(2);
    sb.add(3);
    e1.setSubordinates(sb);
    employees.add(e1);
    Employee e2 = new Employee();
    e2.setId(2);
    e2.setImportance(3);
    e2.setSubordinates(Collections.emptyList());
    employees.add(e2);
    Employee e3 = new Employee();
    e3.setId(3);
    e3.setImportance(3);
    e3.setSubordinates(Collections.emptyList());
    employees.add(e3);
    System.out.println(getImportance(employees, 1));
  }

  public static int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    for (Employee employee : employees) {
      employeeMap.put(employee.getId(), employee);
    }
    Queue<Employee> q = new ArrayDeque<>();
    q.offer(employeeMap.get(id));
    int ans = 0;
    while (!q.isEmpty()) {
      Employee e = q.poll();
      ans += e.getImportance();
      for (Integer subordinate : e.subordinates) {
        q.offer(employeeMap.get(subordinate));
      }
    }
    return ans;
  }

}
