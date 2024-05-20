package com.cskaoyan.mapper;

import com.cskaoyan.bean.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    //多对多的分次查询
    Student selectStudentByNameCountQuery(@Param("name") String name);

    //多对多的连接查询
    Student selectStudentByNameCrossQuery(@Param("name") String name);
}
