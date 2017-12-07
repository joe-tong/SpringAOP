package com.demo.aop.proxy;

/**
 * @author zhangwei
 * @version V1.0
 * @Title: com.demo.aop.proxy
 * @Package SpringAOP
 * @Description: TODO
 * @date 2017-10-18 16:29
 */
public interface SleepDao {
    /**
     * 睡觉之前 你要脱衣服
     * 睡觉
     * 睡完之后穿衣服
     */
    public void asleep();
    public void bsleep();
}
