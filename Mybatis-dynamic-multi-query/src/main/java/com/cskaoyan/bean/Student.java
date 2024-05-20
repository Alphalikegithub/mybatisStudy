package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description: 学生类
 * @since 2024-04-24 21:32
 **/
@Data
public class Student {
    Integer id;
    String name;
    Integer age;
    String gender;
    Integer clazzId;

    //Clazz clazz;//一个学生对应一个班级

    //Course和Student根据需求在一方维护即可
    List<Course> courseList;
}
