package com.demo.aop;

import com.demo.aop.dao.DbProxy;
import com.demo.aop.dao.UserDao;
import com.demo.aop.dao.UserDaoImpl;
import com.demo.aop.proxy.SleepDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 第一  要代理的类  接口+实现类
 * 第二步  代理  要实现响应的接口的方法
 * 第三步  配置xml文件
 * 1. 注册相关的类   代理类+被代理类的实现的接口
 * 2, 配置切入点
 * 3. 配置通知
 * 4. 配置切面
 * 第四步就调用
 * 调用切面对象 生成代理的接口对象
 *
 */
public class TestMain {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        SleepDao dao = (SleepDao) context.getBean("aspect");
//        dao.bsleep();

        UserDao instance = (UserDao) new DbProxy().newInstance(new UserDaoImpl());
        User user = new User();

        instance.save(user);

    }
}
