package com.jack.review.test.DesignPatterns.behavior.state2;

/**
 * @Description: 中午工作状态
 * @Auther: Jack You
 * @Date: 2021/05/26/17:34
 */
public class AfterNoonState extends State {
    @Override
    public void WriteProgram(Work w) {
        if (w.getHour() < 17) {
            System.out.println(String.format("当前时间：[%s]点，下午工作，继续努力", w.getHour()));
        } /*else {
            //超过17点，则转入晚上工作状态
            w.SetState(new EveningState());
            w.WriteProgram();
        }*/
    }
}
