package com.atguigu.springboot;

import com.atguigu.springboot.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yooyu
 * @date 2020/10/23 20:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void findAll(){
        userMapper.selectAll().forEach(System.out::println);
    }
}
