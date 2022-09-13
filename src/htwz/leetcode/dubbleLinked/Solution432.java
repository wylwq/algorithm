package htwz.leetcode.dubbleLinked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 432. 全 O(1) 的数据结构
 *
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 *
 * @author wangyu
 * @since 2022/9/13 23:22
 */
public class Solution432 {

  public static void main(String[] args) {
    Solution432 obj = new Solution432();
    obj.inc("hello");
    obj.inc("hello");
    String param_3 = obj.getMaxKey();
    String param_4 = obj.getMinKey();
    System.out.println(param_3);
    System.out.println(param_4);
  }

  Map<String,Integer> map;
  TreeMap<Integer, Set<String>> freq;
  public Solution432() {
    map=new HashMap<>();
    freq=new TreeMap<>();
  }

  public void inc(String key) {
    map.put(key,map.getOrDefault(key,0)+1);
    int count=map.get(key);//目前的频率
    if(count>1){
      if(freq.get(count-1).size()==1){freq.remove(count-1);}
      else{freq.get(count-1).remove(key);}
    }
    freq.putIfAbsent(count,new HashSet<>());
    freq.get(count).add(key);
  }

  public void dec(String key) {
    int count=map.get(key);//目前的频率
    if(freq.get(count).size()==1){freq.remove(count);}
    else{freq.get(count).remove(key);}
    if(count==1){map.remove(key);}
    else{map.put(key,count-1);}
    if(count>1){
      freq.putIfAbsent(count-1,new HashSet<>());
      freq.get(count-1).add(key);
    }
  }

  public String getMaxKey() {
    if(map.size()>0){
      Integer a=freq.lastKey();
      for(String s:freq.get(a)){return s;}
    }
    return "";
  }

  public String getMinKey() {
    if(map.size()>0){
      Integer a=freq.firstKey();
      for(String s:freq.get(a)){return s;}
    }
    return "";
  }

}
