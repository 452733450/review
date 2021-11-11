package com.jack.review.test.mysql;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/16/17:05
 */
public class yearweek {
    // 查询当前时间本周数据（1表示从本周一开始）
    // select * from sys_remind where yearweek( date_format(remindDate,'%y-%m-%d' ),1 ) = yearweek('2021-09-22 11:08:26', 1) order by remindDate ASC ;


    /*-- 查询上周数据(addtime为datetime格式)
    SELECT id,addtime FROM mall_order WHERE YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1;*/

    // https://blog.csdn.net/torpidcat/article/details/80860665
}
