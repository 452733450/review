package com.jack.review.test.mysql;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/10:20
 */
public class exists {
    // 外层查询表小于子查询表，则用exists，外层查询表大于子查询表，则用in，如果外层和子查询表差不多，则爱用哪个用哪个

    /*SELECT * FROM `user`
    WHERE exists (SELECT * FROM `order` WHERE user.id = order.user_id)*/

    /*SELECT * FROM `user`
    WHERE id in (SELECT user_id FROM `order`)*/


    /*SELECT * FROM customer c
    WHERE EXISTS (SELECT * FROM share_record s WHERE s.customerId = c.customerId)

    SELECT * FROM customer c WHERE c.customerId in (SELECT customerId FROM share_record)*/
}
