package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description:
 * @since 2024-04-06 14:29
 **/

public interface UserMapper {
    User selectUserByIdCountQuery(@Param("id") Integer id);
    User selectUserByIdCrossQuery(@Param("id") Integer id);
}
