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
 * @program: Java_2024
 * @description:
 * @since 2024-04-02 16:13
 **/

public class UserTest {
    static SqlSession sqlSession;
    static UserMapper userMapper;
    static ClazzMapper clazzMapper;
    static StudentMapper studentMapper;
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
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testSelectUserByIdCountQuery(){
        User user = userMapper.selectUserByIdCountQuery(2);
        System.out.println(user);
    }

    @Test
    public void testSelectUserByIdCrossQuery(){
        User user = userMapper.selectUserByIdCrossQuery(2);
        System.out.println(user);
    }

    @Test
    public void testSelectClazzByName(){
        Clazz clazz = clazzMapper.selectClazzByName("一班");
        System.out.println(clazz);
        Clazz 二班 = clazzMapper.selectClazzByName("二班");
        System.out.println(二班);

    }

    @Test
    public void testSelectClazzByNameUseCrossQuery(){
        Clazz clazz = clazzMapper.selectClazzByNameUseCrossQuery("三班");
        System.out.println(clazz);
    }

    @Test
    public void testSelectStudentByNameCountQuery(){
        Student student = studentMapper.selectStudentByNameCountQuery("张三");
        System.out.println(student);
    }

    @Test
    public void testSelectStudentByNameCrossQuery(){
        Student student = studentMapper.selectStudentByNameCrossQuery("貂蝉");
        System.out.println(student);
    }
}

