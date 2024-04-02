package com.cskaoyan;

import com.cskaoyan.bean.User;
//1.定义一个接口
public interface UserMapper {

    User selectUserById(Integer id);
}
