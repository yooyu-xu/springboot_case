package com.atguigu.springboot.service;

import com.atguigu.springboot.pojo.User;

import java.util.List;

/**
 * @author yooyu
 * @date 2020/10/23 20:33
 */
public interface UserService {
    public List<User> findAll();

}
