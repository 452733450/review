package com.jack.review.test.DesignPatterns.behavior.state2;

/**
 * @Description: 中午工作状态
 * @Auther: Jack You
 * @Date: 2021/05/26/17:34
 */
public class NoonState extends State {
    @Override
    public void WriteProgram(Work w) {
        if (w.getHour() < 13) {
            System.out.println(String.format("当前时间：[%s]]点，中午休息，精神百倍", w.getHour()));
        } else {
            //超过12点，则转入下午工作状态
            w.SetState(new AfterNoonState());
            w.WriteProgram();
        }
    }
}
