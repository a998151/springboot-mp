package com.example.springbootmp.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author BCY
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    private PersonManager personManager;

    @Autowired
    private UserManager userManager;

    @GetMapping("/test")
    public String test(){
        return personManager.say()  + " ---- " + userManager.so();
    }
}
