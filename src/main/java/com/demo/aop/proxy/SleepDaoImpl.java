package com.demo.aop.proxy;

/**
 * 想睡觉
 * Spring 面向切面编程的方式去实现
 *
 * 第一步  创建要代理的对象
 * 第二歩  生成代理类
 * @author zhangwei
 * @version V1.0
 * @Title: com.demo.aop.proxy
 * @Package SpringAOP
 * @Description: TODO
 * @date 2017-10-18 16:31
 */
public class SleepDaoImpl implements SleepDao {
    @Override
    public void asleep() {
        System.out.println("睡觉ing");
    }

    @Override
    public void bsleep() {
        System.out.println(1111);
    }

}
