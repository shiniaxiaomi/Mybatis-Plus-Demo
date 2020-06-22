package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",1);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);

//        userMapper.insert(new User());

        List<User> users = userMapper.selectByUserName("Jack");
        for (User user1 : users) {
            System.out.println(user1);
        }


        List<User> list = userMapper.selectByAge(new Page<>(2, 2),-1);
        for (User user1 : list) {
            System.out.println(user1);
        }

        Page<User> userPage = userMapper.selectPage(new Page<>(2, 2), new QueryWrapper<>());//分页从1开始
        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }

    }

}
