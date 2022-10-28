package com.springboot.userdao.controller;

import com.springboot.userdao.dao.UserDao;
import com.springboot.userdao.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user")
    public void add(@RequestBody User user) throws SQLException{
        userDao.add(new User(user.getId(), user.getName(), user.getPassword()));
    }

    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() throws SQLException{
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
