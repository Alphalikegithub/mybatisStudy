package com.cskaoyan.bean;

import lombok.Data;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description:
 * @since 2024-04-06 14:27
 **/
@Data
public class User {
    Integer id;
    String username;
    String nickname;
    String gender;
    Integer age;
    UserDetail detail;
}
