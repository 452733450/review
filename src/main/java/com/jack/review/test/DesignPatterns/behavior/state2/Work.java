package com.jack.review.test.DesignPatterns.behavior.state2;

import lombok.Data;

/**
 * @Description: 工作类，Context类，维护一个ConcreteState子类（工作状态类）的实例，这个实例定义当前的状态
 * @Auther: Jack You
 * @Date: 2021/05/26/17:34
 */
@Data
public class Work {
    private State current;
    private double hour;
    private boolean finish = false;

    public Work() {
        //工作初始化为上午工作状态
        current = new ForeNoonState();
    }

    public void SetState(State s) {
        current = s;
    }

    public void WriteProgram() {
        current.WriteProgram(this);
    }
}
