package com.atguigu.springboot.controller;

import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yooyu
 * @date 2020/10/23 20:32
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/findAll")
    public Result findAll(){
        try {
            List<User> all = userService.findAll();
            return Result.ok(true,"成功",all);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(false,"失败");
        }
    }
}
