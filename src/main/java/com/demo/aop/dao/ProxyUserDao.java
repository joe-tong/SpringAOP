package com.demo.aop.dao;

import com.demo.aop.User;

public class ProxyUserDao implements UserDao {
    private UserDao userDao;

    public ProxyUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void open() {
//        打开数据库
        System.out.println("连接数据库");
    }

    public void openTransaction() {
        System.out.println("开启事务");
    }

    public void commit() {
        System.out.println("提交事物");
    }

    public void close() {
        System.out.println("提交事物");
    }

    @Override
    public void save(User user) {
        open();
        openTransaction();
        userDao.save(user);
        commit();
        close();
    }

    @Override
    public void update() {
        open();
        openTransaction();
        userDao.update();
        commit();
        close();
    }

    @Override
    public void delete() {
        open();
        openTransaction();

        commit();
        close();


    }
}
