package com.cskaoyan;

import com.cskaoyan.bean.User;
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
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 16:13
 **/

public class MybatisProxySettingsTest {
    public static SqlSession sqlSession;
    @BeforeClass
    public static void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //InputStream inputStream = MybatisProxyTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        InputStream inputStream1 = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream1);
        //设置自动提交
        sqlSession = sqlSessionFactory.openSession(true);

    }
    @Test
    public void testSelectUserById(){
        //1.之前的方式
        /*User user = sqlSession.selectOne("com.cskaoyan.UserMapper.selectUserById",2);
        System.out.println(user);*/
        //2.新的方式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(2);
        System.out.println(user);
    }
}
