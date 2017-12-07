package com.demo.aop.dao;

import com.demo.aop.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("保存对象");
    }

    @Override
    public void update() {
        System.out.println("更新成功");
    }

    @Override
    public void delete() {

    }
}
