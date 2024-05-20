package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description:
 * @since 2024-04-24 21:32
 **/
@Data
public class Clazz {
    Integer id;
    String name;

    //维护一个学生类的集合
    List<Student> studentList;
}
