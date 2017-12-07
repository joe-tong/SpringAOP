package com.demo.aop.service;

import com.demo.aop.User;
import com.demo.aop.dao.UserDao;
import com.demo.aop.dao.UserDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.beans.Transient;
import java.util.logging.Logger;

/**
 *  把你写代码
 *
 *  反射性能比较差 下降20%
 */
public class UserServiceImpl {


    UserDao dao = new UserDaoImpl();
    Log log = new Log4JLogger();

    @Transient
    public void update() {
        //开启事物
        dao.update();
        //提交事物
    }

    public void save()
    {
        System.out.println(System.currentTimeMillis());
        //开启事物
        dao.save(new User());
        //提交事物  或者回滚
        System.out.println(System.currentTimeMillis());
    }


}
