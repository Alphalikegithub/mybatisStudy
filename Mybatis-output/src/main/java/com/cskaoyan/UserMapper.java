package com.cskaoyan;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.User2;
import org.apache.ibatis.annotations.Param;

import java.util.*;

//1.定义一个接口
public interface UserMapper {

    //一个简单类型
    int selectUserCount();
    //多个简单类型
    List<Integer> selectUserList();

    //返回多个String name 类型
    List<String> selectNameList();
    //返回单个对象
    User selectUserById(@Param("id") Integer id);

    //返回多个对象的集合
    List<User> selectUserByMinId(@Param("minId") Integer minId);

    //User2 selectUser2ByIdUserResultMap(@Param("id") Integer id);

    User selectUserByName(@Param("name") String name);
}
