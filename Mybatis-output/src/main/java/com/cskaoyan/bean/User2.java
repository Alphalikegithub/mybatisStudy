package com.cskaoyan.bean;

import java.util.Date;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 00:11
 **/

public class User2 {
    Integer uid;
    String username;
    Date birthday;

    @Override
    public String toString() {
        return "User2{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
