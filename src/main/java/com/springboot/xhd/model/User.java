package com.springboot.xhd.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private int age;

    @JSONField(format = "yyyy-MM-dd HH-mm")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
