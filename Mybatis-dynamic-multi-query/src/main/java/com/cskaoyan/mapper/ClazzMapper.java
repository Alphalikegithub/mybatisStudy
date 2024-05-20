package com.cskaoyan.mapper;

import com.cskaoyan.bean.Clazz;
import org.apache.ibatis.annotations.Param;

public interface ClazzMapper {
    Clazz selectClazzByName(@Param("name") String name);

    Clazz selectClazzByNameUseCrossQuery(@Param("name") String name);
}
