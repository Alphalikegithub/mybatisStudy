package com.cskaoyan;

import com.cskaoyan.bean.Clazz;
import com.cskaoyan.bean.Student;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.ClazzMapper;
import com.cskaoyan.mapper.StudentMapper;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author alpha
 * @program: mybatisStudy
 * @description:
 * @since 2024-04-25 00:04
 **/

public class LazyLoadTest {
    static SqlSession sqlSession;
    static UserMapper userMapper;
    static ClazzMapper clazzMapper;
    @BeforeClass
    public static void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //InputStream inputStream = MybatisProxyTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        InputStream inputStream1 = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream1);
        //设置自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        //需要避免空指针异常
        userMapper = sqlSession.getMapper(UserMapper.class);
        clazzMapper = sqlSession.getMapper(ClazzMapper.class);
    }

    @Test
    public void testSelectUserByIdCountQuery(){
        User user = userMapper.selectUserByIdCountQuery(2);
        System.out.println(user);
    }
}
