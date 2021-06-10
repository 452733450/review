package com.jack.review.test.DesignPatterns.behavior.state;

/**
 * @Description: 减库存的状态
 * @Auther: Jack You
 * @Date: 2021/05/26/16:38
 */
public class DeductState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("商品卖出，准备减库存");
        context.setState(this);

        //... 执行减库存的具体操作
    }

    public String toString() {
        return "Deduct State";
    }
}
