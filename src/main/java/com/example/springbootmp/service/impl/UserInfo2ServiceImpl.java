package com.example.springbootmp.service.impl;

import com.example.springbootmp.entity.UserInfo;
import com.example.springbootmp.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author BCY
 */
@Slf4j
@Service
public class UserInfo2ServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional(rollbackFor = Exception.class , propagation = Propagation.REQUIRES_NEW)
    public void updateNew() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("阿牛");
        userInfo.setAge(10);
        userInfo.setSex("男");
        userInfoMapper.insert(userInfo);
        log.info("ok");
    }
}
