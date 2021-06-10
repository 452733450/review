package com.jack.review.test.DesignPatterns.creational.factory.byEnum;

import com.jack.review.test.DesignPatterns.creational.factory.ChineseFoodA;
import com.jack.review.test.DesignPatterns.creational.factory.ChineseFoodB;
import com.jack.review.test.DesignPatterns.creational.factory.Food;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:25
 */
public enum ChineseFoodFactory implements FoodFactory {

    A(){
        @Override
        public Food makeFood() {
            return new ChineseFoodA();
        }
    },
    B(){
        @Override
        public Food makeFood() {
            return new ChineseFoodB();
        }
    }



}
