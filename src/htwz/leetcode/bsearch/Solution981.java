package htwz.leetcode.bsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 981. 基于时间的键值存储
 *
 * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
 *
 * 实现 TimeMap 类：
 *
 * TimeMap() 初始化数据结构对象
 * void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳 timestamp。
 * String get(String key, int timestamp)
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 *
 * @author wangyu
 * @since 2022/8/11 23:06
 */
public class Solution981 {

    private static final Map<String, TreeMap<Integer, String>> TIME_MAP = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = TIME_MAP.computeIfAbsent(key, e -> new TreeMap<>());
        treeMap.put(timestamp, value);
    }

    /**
     * floorEntry 此方法返回最大 key 小于或等于key的条目，如果没有这样的 key ，则返回null
     * @param key
     * @param timestamp
     * @return
     */
    public static String get(String key, int timestamp) {
        Map.Entry<Integer, String> entry = TIME_MAP.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();

    }
}
