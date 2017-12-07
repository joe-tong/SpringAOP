package com.demo.aop.proxy;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author zhangwei
 * @version V1.0
 * @Title: com.demo.aop.proxy
 * @Package SpringAOP
 * @Description: TODO
 * @date 2017-10-18 15:40
 * 辅助代理类
 * 1.睡觉之前脱衣服
 * 2.醒了穿衣服
 */
public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("睡觉之前脱衣服");
//        method.invoke(target, args);
//       开启事物
    }
//
//    public void throwsAdvice()   {
//        System.out.println("睡觉中断");
//        //回滚
//    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("醒了之后继续睡觉!");
    }
}
