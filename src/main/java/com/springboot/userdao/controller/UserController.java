package com.springboot.userdao.controller;

import com.springboot.userdao.dao.UserDao;
import com.springboot.userdao.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/vi")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao=userDao;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/user")
    public void add() throws SQLException{
        userDao.add(new User("1","Kyeongrok", "1234"));
    }
}
