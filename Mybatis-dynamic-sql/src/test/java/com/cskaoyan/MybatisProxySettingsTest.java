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
import java.util.ArrayList;
import java.util.Date;
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
        User user = userMapper.selectUserById(2);
        System.out.println(user);
    }

    @Test
    public void testSelectUserListById(){
        List<User> userList = userMapper.selectUserListById(11);
        System.out.println(userList);
    }

    @Test
    public void testSelectUserListByUserSelective(){
        User user = new User();
        user.setId(11);
        user.setName("王有胜");
        List<User> userList = userMapper.selectUserListByUserSelective(user);
        System.out.println(userList);
    }

    @Test
    public void testSelectUserListMatchById(){
        List<User> userList = userMapper.selectUserListMatchById(20);
        System.out.println(userList);
    }

    @Test
    public void testUpdateUserByIdSelective(){
        User user = new User();
        user.setId(9);
        user.setName("孙悟空");
        user.setBirth(new Date());
        int affectRows = userMapper.updateUserByIdSelective(user);
        System.out.println(affectRows);
    }

    @Test
    public void testUpdateUserByIdSelectiveUseSet(){
        User user = new User();
        user.setId(8);
        user.setName("沙悟净");
        int affectRows = userMapper.updateUserByIdSelectiveUseSet(user);
        System.out.println(affectRows);
    }

    @Test
    public void testinsertUserReturnId(){
        User user = new User();
        user.setName("花园宝宝");
        user.setBirth(new Date());
        int affectRows = userMapper.insertUserReturnId(user);
        System.out.println("affectRows = " + affectRows);
        System.out.println("id = " + user.getId());
    }

    @Test
    public void testSelectUserListByIdUserList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<User> userList = userMapper.selectUserListByIdUserList(list);
        System.out.println(userList);
    }

    @Test
    public void testSelectUserListByIdUserArray(){
        Integer[] arr = {1,2,3,4,5};
        List<User> userList = userMapper.selectUserListByIdUserArray(arr);
        System.out.println(userList);
    }
    @Test
    public void testInsertUserList(){
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User(30,"秀才",new Date());


        User user2 = new User(31,"进士",new Date());

        User user3 = new User(32,"举人",new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);

        int affectRows = userMapper.insertUserList(users);
        System.out.println(affectRows);
        System.out.println("affectRows = " + affectRows);
        //把这方面的笔记给做一下  今后大家如果想联系相关的项目 可以联系我添加这些类似的只是
    }
}

