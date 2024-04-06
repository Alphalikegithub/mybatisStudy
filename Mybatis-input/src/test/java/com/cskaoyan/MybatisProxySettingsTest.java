package com.cskaoyan;

import com.cskaoyan.bean.User;
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
    public void testSelectUserById(){
        //1.之前的方式
        /*User user = sqlSession.selectOne("com.cskaoyan.UserMapper.selectUserById",2);
        System.out.println(user);*/
        //2.新的方式
        //UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(2);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        int affectedRows = userMapper.insertUser(11, "天线宝宝", new Date());
        System.out.println(affectedRows);
    }

    @Test
    public void testInsertUserWithUser(){
        User user = new User();
        user.setId(12);
        user.setName("流沙河");
        user.setBirth(new Date());
        int affectedRows = userMapper.insertUserWithUser(user);
        System.out.println(affectedRows);
    }
    @Test
    public void testUpdateUserById(){
        User user = new User();
        user.setName("王有胜");
        user.setBirth(new Date());
        int affectedRows = userMapper.updateUserById(11, user);
        System.out.println(affectedRows);
    }
    //不推荐使用map传值
    @Test
    public void testSelectUserByMap(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",12);
        hashMap.put("name","王有胜");
        List<User> userList = userMapper.selectUserByMap(hashMap);
        System.out.println(userList);
    }

    @Test
    public void testInsertUserWithIndex(){
        int affectRows = userMapper.insertUserWithIndex(29, "生辰纲", new Date( ));
        System.out.println(affectRows);
    }

    @Test
    public void testSelectUserByIdAndTableName(){
        User user = userMapper.selectUserByIdAndTableName(28,"user");
        System.out.println(user);
    }

    @Test
    public  void  testSelectUserListByStartIndexAndPageNum(){
        List<User> userList = userMapper.selectUserListByStartIndexAndPageNum(1, 2);
        System.out.println(userList);
    }
}
