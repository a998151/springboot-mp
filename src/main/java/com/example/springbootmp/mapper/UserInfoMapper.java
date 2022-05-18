package com.example.springbootmp.mapper;

import com.example.springbootmp.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 阿牛
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2022-05-18 11:54:33
* @Entity com.example.springbootmp.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




