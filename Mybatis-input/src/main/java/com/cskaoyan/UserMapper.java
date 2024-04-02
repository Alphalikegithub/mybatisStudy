package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

//1.定义一个接口
public interface UserMapper {

    User selectUserById(Integer id);

    int insertUser(@Param("id") Integer id,@Param("name") String name,@Param("birth") Date birth);

    int insertUserWithUser(User user);
}
