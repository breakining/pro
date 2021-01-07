package com.ghw.base.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/11/2 9:44
 */
@Data
@Accessors(chain = true)
public class Order implements Comparable<Order>{

    private String orderNm;

    @Override
    public int compareTo(Order o) {
        if(this.getOrderNm().length() >= o.getOrderNm().length()){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNm='" + orderNm + '\'' +
                '}';
    }
}
