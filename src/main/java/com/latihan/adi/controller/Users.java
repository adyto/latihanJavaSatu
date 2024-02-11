package com.latihan.adi.controller;


import com.latihan.adi.entity.TblUsers;
import com.latihan.adi.pojo.UsersPostPojo;
import com.latihan.adi.service.UserPostService;
import com.latihan.adi.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Users {

    @Autowired
    private UserPostService userPostService;

    @PostMapping("/add/user")
    private ResponseEntity<MessageModel> addUsers(@RequestBody UsersPostPojo usersPostPojo) {
        ResponseEntity responseEntity = userPostService.addDataUsers(usersPostPojo);
        return responseEntity;
    }

}
