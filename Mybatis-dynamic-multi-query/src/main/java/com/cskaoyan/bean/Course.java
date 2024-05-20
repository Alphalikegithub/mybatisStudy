package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description: 课程
 * @since 2024-04-24 22:52
 **/
@Data
public class Course {
    Integer id;
    String name;
    String teacherName;
    Integer score;
    //可以维护么只要查询的时候不去关联就可以了
    //List<Student> studentList;
}
