package com.atguigu.springboot;

import com.atguigu.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yooyu
 * @date 2020/10/23 20:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void findAll(){
        userService.findAll().forEach(System.out::println);
    }
}
