package com.example.springbootmp.service;

import com.example.springbootmp.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 阿牛
* @description 针对表【user_info】的数据库操作Service
* @createDate 2022-05-18 11:54:33
*/
public interface UserInfoService extends IService<UserInfo> {

    void insertNew();

    void updateNew();

    void insert3();

    void insert4();
}
