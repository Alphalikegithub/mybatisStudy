package com.cskaoyan.bean;

import java.util.Date;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 00:11
 **/

public class User {
    Integer id;
    String name;
    Date birth;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
