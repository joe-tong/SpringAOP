package com.demo.aop.dao;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangwei
 * @version V1.0
 * @Title: com.demo.aop.dao
 * @Package SpringAOP
 * @Description: TODO
 * @date 2017-10-18 14:22
 */
public class CGLibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    /**
     * 生成代理的步骤
     *
     * @param cls
     * @return
     */
    public Object getProxy(Class cls) {
        enhancer.setCallback(this);
        enhancer.setSuperclass(cls);
        return enhancer.create();
//        enhancer.create()
//        Proxy.newProxyInstance()


    }


    /**
     * 重写 intercept 拦截的方法
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object invoke = null;
        if ("save".equals(method.getName())) {
            System.out.println("在核心方法之前执行");
            //代理方法执行父类的方法
            invoke = methodProxy.invokeSuper(o, objects);
//            method.invoke(o,objects);
            System.out.println("在核心方法之后执行");
        } else if ("update".equals(method.getName())) {



        }
        return invoke;
    }
}
