package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 11:42
 **/

public class MybatisTest {
    static SqlSession sqlSession;
    /*static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
    }*/

    @BeforeClass
    public static void init(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
        //默认创建的sqlSession不会自动提交事务,需要我们手动提交
        //2.可以自动提交的sqlSession--->sqlSession = sqlSessionFactory.openSession(true);
    }
    @After
    public  void commit(){
        System.out.println("afterClass");
        sqlSession.commit();
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setId(9);
        user.setName("武松");
        user.setBirth(new Date());
        int affectRows = sqlSession.insert("cskaoyan.insertUser", user);
        System.out.println(affectRows);
    }

    @Test
    public void deleteById(){
        int affectRows = sqlSession.delete("cskaoyan.deleteUserById",23);
        System.out.println(affectRows);
    }
    @Test
    public void testUpdateUserByIs(){
        User user = new User();
        user.setId(9);
        user.setName("哇哈哈");

        int affectRows = sqlSession.update("cskaoyan.updateUserById", user);
        System.out.println(affectRows);
    }


}
