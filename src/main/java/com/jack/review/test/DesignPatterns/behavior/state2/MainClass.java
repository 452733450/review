package com.jack.review.test.DesignPatterns.behavior.state2;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/26/17:45
 */
public class MainClass {
    /*在对象的行动取决于本身的状态时，可以适用于状态模式，免去了过多的if–else判断，
    这对于一些复杂的和繁琐的判断逻辑有很好的帮助。
    但是使用状态模式，势必会造成更多的接口和类，对于非常简单的状态判断，可以不使用*/
    public static void main(String[] args) {
        Work w = new Work();
        w.setHour(9);
        w.WriteProgram();

        w.setHour(10);
        w.WriteProgram();

        w.setHour(12);
        w.WriteProgram();

        w.setHour(16);
        w.WriteProgram();
    }
}
