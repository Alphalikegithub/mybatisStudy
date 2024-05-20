package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//1.定义一个接口
public interface UserMapper {
    User selectUserById(@Param("id") Integer id);

    List<User> selectUserListById(@Param("id") Integer id);

    //通过User对象 动态的去查询User
    List<User> selectUserListByUserSelective(@Param("user") User user);

    /*根据传入的id匹配条件
    当传入的id>20的时候，查询id>20的用户
    否则，查询id < 20 的用户*/
    List<User> selectUserListMatchById(@Param("id") Integer id);

    /*动态的根据id修改User
    假如User中传入了name,那我们就修改name
    假如User中传入了birth,那我们就修改birth*/
    int updateUserByIdSelective(@Param("user") User user);

    int updateUserByIdSelectiveUseSet(@Param("user") User user);

    //插入一个用户 并且获得自增的id
    int insertUserReturnId(@Param("user") User user);

    //in查询
    List<User> selectUserListByIdUserList(@Param("ids") List<Integer> ids);
    List<User> selectUserListByIdUserArray(@Param("ids") Integer[] ids);

    //批量插入
    int insertUserList(@Param("userList") List<User> userList);
}
