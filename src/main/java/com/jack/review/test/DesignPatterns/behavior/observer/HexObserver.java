package com.jack.review.test.DesignPatterns.behavior.observer;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/15:13
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String result = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("订阅的数据发生变化，新的数据处理为十六进制值为：" + result);
    }
}
