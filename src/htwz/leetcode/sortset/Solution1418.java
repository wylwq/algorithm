package htwz.leetcode.sortset;

import java.util.*;

/**
 * 简单模拟题，
 * 使用一个 set 记录一下 table， 这样方便后续操作
 *
 * @author wangyu
 * @since 2022/5/23 21:40
 */
public class Solution1418 {

    public static void main(String[] args) {
        //[["David","3","Ceviche"]]
        //["Corina","10","Beef Burrito"]
        List<List<String>> list = new ArrayList<>();
        List<String> table = new ArrayList<>();
        table.add("David");
        table.add("3");
        table.add("Ceviche");
        list.add(table);
        List<String> table1 = new ArrayList<>();
        table1.add("Corina");
        table1.add("10");
        table1.add("Burrito");
        list.add(table1);
        List<String> table2 = new ArrayList<>();
        table2.add("Corina");
        table2.add("10");
        table2.add("Burrito");
        list.add(table2);
        List<List<String>> list1 = displayTable(list);
        for(List<String> e : list1) {
            System.out.println(e);
        }
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        // 桌号 : {餐品 : 个数}（用于构造内容）
        Map<Integer, Map<String, String>> map = new TreeMap<>();
        // 餐品（用于构造 title）
        Set<String> ts = new HashSet<>();
        for(int i = 0; i < orders.size(); i++) {
            List<String> order = orders.get(i);
            Integer tableNum = Integer.valueOf(order.get(1));
            Map<String, String> entry = map.getOrDefault(tableNum, new TreeMap<>());
            entry.put(order.get(2), Integer.valueOf(entry.getOrDefault(order.get(2), "0")) + 1 + "");
            map.put(tableNum, entry);
            ts.add(order.get(2));
        }

        List<List<String>> ans = new ArrayList<>();

        // 构造 title & 手动排序
        List<String> foods = new ArrayList<>(ts);
        Collections.sort(foods);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foods);
        ans.add(title);


        for(Map.Entry<Integer, Map<String, String>> entry : map.entrySet()) {
            List<String> item = new ArrayList<>();
            item.add(entry.getKey() + "");
            Map<String, String> value = entry.getValue();
            for (String food : foods) {
                item.add(value.getOrDefault(food, "0"));
            }
            ans.add(item);
        }
        return ans;
    }
}
