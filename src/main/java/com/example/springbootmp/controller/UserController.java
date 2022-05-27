package com.example.springbootmp.controller;

import com.example.springbootmp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BCY
 */
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/test")
    public String test(){
        userInfoService.insert4();
        return "ok";
    }
}
