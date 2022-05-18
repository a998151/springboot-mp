package com.example.springbootmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmp.entity.UserInfo;
import com.example.springbootmp.service.UserInfoService;
import com.example.springbootmp.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author 阿牛
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2022-05-18 11:54:33
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}




