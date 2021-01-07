package com.ghw.base.utils.sql;

import com.ghw.base.model.Order;
import com.ghw.base.utils.SortUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/10/28 15:30
 */
public class Test {

    public static void main(String[] args) {

//        Map<String, List<Object>> oldMap = Maps.newHashMap();
//        List<Object> data1 = Lists.newArrayList();
//        List<Object> data2 = Lists.newArrayList();
//        List<Object> data3 = Lists.newArrayList();
//        data1.add(1);
//        data1.add(2);
//        data2.add(3);
//        data2.addAll(data1);
//        data3.add(4);
//        data3.addAll(data2);
//        oldMap.put("1", data2);
//        oldMap.put("2", data1);
//        oldMap.put("3", data3);
//        Map<String, List<Object>> map = SortUtils.instance().mapSortValueDesc(oldMap);
//        System.out.println(123);

        Map<Object, Order> oldMap = Maps.newHashMap();
        Order order1 = new Order().setOrderNm("123");
        Order order2 = new Order().setOrderNm("1234");
        Order order0 = new Order().setOrderNm("12");
        oldMap.put("123", order1);
        oldMap.put("1234", order2);
        oldMap.put("12", order0);
        Map<Object, Order> objectOrderMap = SortUtils.mapSort(oldMap, SortUtils.SortType.ASC);
        objectOrderMap.forEach((k,v) ->{
            System.out.println(k + "--"+ v.toString());
        });
    }
}
