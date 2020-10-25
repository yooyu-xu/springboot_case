package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author yooyu
 * @date 2020/10/23 20:34
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class
    )
    @Override
    public List<User> findAll() {
        //int i = 1/0; //运行时异常，Spring AOP 声明式事务，默认对于运行时异常进行回滚。
        //FileInputStream xxx = new FileInputStream("xxx");  //编译期异常；默认不回滚的
        List<User> users = (List<User>) redisTemplate.boundValueOps("userkey").get();
        //没有缓存
        if(users == null){
            users = userMapper.selectAll();
            System.out.println(users);
            redisTemplate.boundValueOps("userkey").set(users);
        }else{
            System.out.println("冲缓存中获取 users => " + users);
        }
        return users;
    }
}
