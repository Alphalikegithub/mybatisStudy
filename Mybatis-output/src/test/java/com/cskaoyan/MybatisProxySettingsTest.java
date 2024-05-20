package com.cskaoyan;

import com.cskaoyan.bean.Student;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.User2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 16:13
 **/

public class MybatisProxySettingsTest {
    static SqlSession sqlSession;
    static UserMapper userMapper;

    @BeforeClass
    public static void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //InputStream inputStream = MybatisProxyTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        InputStream inputStream1 = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream1);
        //设置自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSelectUserCount() {
        int count = userMapper.selectUserCount();
        System.out.println(count);
    }

    @Test
    public void testSelectUserList() {
        List<Integer> integers = userMapper.selectUserList();
        System.out.println(integers);
    }

    @Test
    public void testSelectNameList(){
        List<String> stringList = userMapper.selectNameList();
        System.out.println(stringList);
    }

    @Test
    public void testSelectUserById(){
        User user = userMapper.selectUserById(3);
        System.out.println(user);
    }

    @Test
    public void testSelectUserByMinId(){
        List<User> userList = userMapper.selectUserByMinId(4);
        System.out.println(userList);
    }

    @Test
    public void testSelectUser2ByIdUserResultMap(){
        User2 user2 = userMapper.selectUser2ByIdUserResultMap(2);
        System.out.println(user2);
    }

    @Test
    public void testLombok(){
        Student student = new Student();
        student.setId(1);
    }

}

