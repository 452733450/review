package com.jack.review.test.DesignPatterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/14:53
 */
public class Subject {

    private int state;
    private List<Observer> observes = new ArrayList<>();

    public int getState() {
        return state;
    }

    // 数据已变更，通知观察者们
    public void setState(int state) {
        this.state = state;
        notifyAll(observes);
    }

    // 注册观察者
    public void attach(Observer observer){
        observes.add(observer);
    }

    // 通知观察者们
    public void notifyAll(List<Observer> observes){
        for (Observer observer:observes){
            observer.update();
        }
    }
}
