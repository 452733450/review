package com.jack.review.test.DesignPatterns.behavior.state;

/**
 * @Description: 补库存状态
 * @Auther: Jack You
 * @Date: 2021/05/26/16:39
 */
public class RevertState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("给此商品补库存");
        context.setState(this);

        //... 执行加库存的具体操作
    }

    public String toString() {
        return "Revert State";
    }
}
