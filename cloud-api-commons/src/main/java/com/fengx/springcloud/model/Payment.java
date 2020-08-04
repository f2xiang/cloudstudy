package com.fengx.springcloud.model;


import java.io.Serializable;

/**
 * Created by apple on 2020/8/2.
 */

public class Payment implements Serializable {
    private int id;
    private String serial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
