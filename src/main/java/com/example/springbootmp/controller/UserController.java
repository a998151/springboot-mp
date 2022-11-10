package com.example.springbootmp.controller;

import cn.hutool.json.JSONUtil;
import com.example.springbootmp.bo.HelloDTO;
import com.example.springbootmp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @PostMapping("/test2")
    public String test2(@Valid @RequestBody HelloDTO dto) {
        return JSONUtil.toJsonPrettyStr(dto);
    }
}
