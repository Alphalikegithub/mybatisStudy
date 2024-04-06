package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.*;

//1.定义一个接口
public interface UserMapper {

    User selectUserById(Integer id);

    int insertUser(@Param("id") Integer id,@Param("name") String name,@Param("birth") Date birth);

    int insertUserWithUser(User user);

    //通过id修改user的信息
    int updateUserById(@Param("id") Integer id,@Param("user") User user);

    //通过map来传值
    List<User> selectUserByMap(HashMap<String, Object> map);

    //按位置来传值
    int insertUserWithIndex(Integer id,String name,Date birth);
    //传入表名
    User selectUserByIdAndTableName(@Param("id") Integer id,@Param("tableName") String tableName);

    List<User> selectUserListByStartIndexAndPageNum(@Param("startIndex")Integer startIndex,@Param("pageNum")Integer pageNum);
}
