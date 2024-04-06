package com.cskaoyan.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description:
 * @since 2024-04-03 11:38
 **/

public class Student {
    @Setter@Getter
    Integer id;
    String name;
    String gender;
    String nickname;
}
