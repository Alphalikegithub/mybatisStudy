package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {/*

        System.out.println("Hello world!");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //发送SQL 获取结果
        User user = sqlSession.selectOne("cskaoyan.aaa",2);
        System.out.println(user);

        User user1 = sqlSession.selectOne("cskaoyan.bbb",3);
        System.out.println(user1);
        //关闭sqlSession
        sqlSession.close();*/
    }

}