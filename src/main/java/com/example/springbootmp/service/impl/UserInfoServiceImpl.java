package com.example.springbootmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmp.entity.UserInfo;
import com.example.springbootmp.mapper.UserInfoMapper;
import com.example.springbootmp.service.UserInfoService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Properties;

/**
 * @author 阿牛
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2022-05-18 11:54:33
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private UserInfo2ServiceImpl userInfo2Service;

    @Override
    @Transactional
    public void insertNew() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("阿牛");
        userInfo.setAge(10);
        userInfo.setSex("男");

        userInfoMapper.insert(userInfo);

        this.updateNew();
        userInfo2Service.updateNew();
    }

    @Override
    @Transactional(rollbackFor = Exception.class , propagation = Propagation.REQUIRES_NEW)
    public void updateNew() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("阿牛");
        userInfo.setAge(10);
        userInfo.setSex("男");
        userInfoMapper.insert(userInfo);
        log.info("ok");
    }

    @Override
    public void insert3() {
        HikariDataSource dataSource = createDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);  //开启事务

        jdbcTemplate.execute("INSERT INTO user_info(`user_name` , `age` , `sex`) VALUES ('阿牛' , 11 , '男')");
        transactionManager.commit(status);
    }

    public HikariDataSource createDataSource() {
        final Properties config = new Properties();
        config.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/demo_db?useSSL=false&useUnicode=true&characterEncoding=utf8");
        config.put("username", "root");
        config.put("password", "123456");
        config.put("driverClassName", "com.mysql.cj.jdbc.Driver");
        config.put("maximumPoolSize", 20);
        config.put("minimumIdle", 20);
        HikariConfig hikariConfig = new HikariConfig(config);
        //todo 默认采取自动提交,未来要手动提交，并做事务处理
        hikariConfig.setAutoCommit(false);
        return new HikariDataSource(hikariConfig);
    }
}




