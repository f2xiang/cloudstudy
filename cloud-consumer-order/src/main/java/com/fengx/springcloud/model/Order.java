package com.fengx.springcloud.model;

import java.io.Serializable;

/**
 * Created by apple on 2020/8/2.
 */

public class Order implements Serializable{
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
