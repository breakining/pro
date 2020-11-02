package com.ghw.base.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @description: 排序工具类
 * @author: ghwei
 * @version: 1.0 2020/10/28 18:04
 */
public class SortUtils<T> {

    private SortUtils() {
    }

    public static SortUtils instance() {
        return new SortUtils();
    }

    public enum SortType {
        ASC(0), DESC(1),
        ;
        private final int value;

        SortType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }


    /**
     * map按照value进行正序排列：value是实例化的对性，需要实现 Comparable 接口
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> Map<Object, T> mapSortByValueAsc(final Map<Object, T> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /**
     * map按照value进行排倒序：value是实例化的对性，需要实现 Comparable 接口
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> Map<Object, T> mapSortByValueDesc(final Map<Object, T> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /**
     * map按照value进行排序：value集合
     *
     * @param map
     * @return
     */
    public Map<String, List<T>> mapSortValueDesc(final Map<String, List<T>> map) {
        List<Map.Entry<String, List<T>>> list = map.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.valueOf(entry2.getValue().size()).compareTo(entry1.getValue().size()))
                .collect(Collectors.toList());
        final Map<String, List<T>> resultMap = Maps.newLinkedHashMap();
        list.forEach(entry -> resultMap.put(entry.getKey(), entry.getValue()));
        return resultMap;
    }

    /**
     * 传统方法排序
     *
     * @param map
     * @param type
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> Map<Object, T> mapSort(final Map<Object, T> map, SortType type) {
        List<Map.Entry<Object, T>> list = Lists.newArrayList(map.entrySet());
        if (type.value == 0) {
            // 正序
            list.sort(Map.Entry.comparingByValue());
        } else if (type.value == 1) {
            // 反序
            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        }
        final Map<Object, T> resultMap = Maps.newLinkedHashMap();
        list.forEach(entry -> resultMap.put(entry.getKey(), entry.getValue()));
        return resultMap;
    }
}
