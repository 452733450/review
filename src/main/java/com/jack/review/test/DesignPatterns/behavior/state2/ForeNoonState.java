package com.jack.review.test.DesignPatterns.behavior.state2;

/**
 * @Description: 上午工作状态
 * @Auther: Jack You
 * @Date: 2021/05/26/17:34
 */
public class ForeNoonState extends State {
    @Override
    public void WriteProgram(Work w) {
        if (w.getHour() < 12) {
            System.out.println(String.format("当前时间：[%s]]点，上午工作，精神百倍", w.getHour()));
        } else {
            //超过12点，则转入中午工作状态
            w.SetState(new NoonState());
            w.WriteProgram();
        }
    }
}
