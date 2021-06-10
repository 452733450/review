package com.jack.review.test.DesignPatterns.behavior.observer;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/14:38
 */
public class MainClass {
    /*观察者模式对于我们来说，真是再简单不过了。无外乎两个操作，观察者订阅自己关心的主题和主题有数据变化后通知观察者们。
    首先，需要定义主题，每个主题需要持有观察者列表的引用，用于在数据变更的时候通知各个观察者：*/

    /*其实如果只有一个观察者类的话，接口都不用定义了，
    不过，通常场景下，既然用到了观察者模式，我们就是希望一个事件出来了，会有多个不同的类需要处理相应的信息。
    比如，订单修改成功事件，我们希望发短信的类得到通知、发邮件的类得到通知、处理物流信息的类得到通知等*/

    public static void main(String[] args) {
        // 先定义一个主题
        Subject subject = new Subject();
        // 定义观察者
        new BinaryObserver(subject);
        new HexObserver(subject);

        // 模拟数据变更，这个时候，观察者们的 update 方法将会被调用
        subject.setState(11);
    }
}
