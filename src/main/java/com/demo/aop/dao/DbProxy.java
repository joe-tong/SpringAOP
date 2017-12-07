package com.demo.aop.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 第一步 写一个类继承InvocationHandler
 * 第二不  通过 Proxy类指定Classloader 接口还是实现类本省  去创建动态带来对象
 * 第三步 重写invoke方法
 * 在执行核心操作步骤之前做一个公共操作
 * 第四步  调用方法
 * 通过代理的对象的传进代理接口的实现类的示例
 * 返回代理接口类的对象
 */
public class DbProxy implements InvocationHandler {
    /**
     * 代码里的目标对象
     */
    private Object targetObject;
    private int count = 1;
    public static final String SAVE = "save";


    /**
     * @param targetObject
     * @return
     */
    public Object newInstance(Object targetObject) {

        this.targetObject = targetObject;
        /**
         * 代理对象的ClassLoader对象
         */
        ClassLoader loader = targetObject.getClass().getClassLoader();
        Class<?>[] interfaces = targetObject.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        if (SAVE.equals(method.getName())) {
            System.out.println("开启事物");
            obj = method.invoke(targetObject, args);
            System.out.println("提交事物");
        } else if ("update".equals(method.getName())) {
//            面向切面编程
            System.out.println("开启事物");
            obj = method.invoke(targetObject, args);
            System.out.println("提交事物");
        }
        return obj;
    }
}
