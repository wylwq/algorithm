package htwz.algorithm.greedy;

import java.util.*;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/11 21:28
 * @Version V1.0.0
 **/
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Map<String, HashSet<String>> broadsMap = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadsMap.put("K1", hashSet1);
        broadsMap.put("K2", hashSet2);
        broadsMap.put("K3", hashSet3);
        broadsMap.put("K4", hashSet4);
        broadsMap.put("K5", hashSet5);

        HashSet<String> allAreas= new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建一个ArrayList,存放选择的电台集合
        List<String> selects = new ArrayList<>();
        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没覆盖的地区的交集
        Set<String> tempSet = new HashSet<>();
        //定义一个maxkey，保存在一次遍历过程中，能够覆盖最多未覆盖地区对应的电台的key
        String maxKey;
        while (allAreas.size() != 0) {//如果allAreas不为0，则表示还没有覆盖到所有地区
            maxKey = null;
            for (String key : broadsMap.keySet()) {
                tempSet.clear();
                HashSet<String> hashSet = broadsMap.get(key);
                tempSet.addAll(hashSet);
                //求出tempSet和allAreas集合的交集，交集会附给
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadsMap.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区，从allAreas中去掉
                allAreas.removeAll(broadsMap.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是：" + selects);

    }
}
