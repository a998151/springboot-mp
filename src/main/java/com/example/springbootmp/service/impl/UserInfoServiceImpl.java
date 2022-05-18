package com.example.springbootmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmp.entity.UserInfo;
import com.example.springbootmp.service.UserInfoService;
import com.example.springbootmp.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 阿牛
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2022-05-18 11:54:33
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Override
    public void insertNew() {
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("阿牛");
            userInfo.setAge(10);
            userInfo.setSex("男");
            userInfoMapper.insert(userInfo);
            this.updateNew();

            //手动提交
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            //手动回滚
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNew() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("阿牛");
//        userInfo.setAge(10);
        userInfo.setSex("男");
        userInfoMapper.insert(userInfo);
    }
}




