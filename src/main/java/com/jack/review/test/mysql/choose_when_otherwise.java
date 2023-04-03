package com.jack.review.test.mysql;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/18/11:03
 */
public class choose_when_otherwise {
    /*<choose>
            <when test="productName != null and productName != ''">
    inner join product c on c.productId = a.productId
            </when>
            <otherwise>
    left join product c on c.productId = a.productId
            </otherwise>
    </choose>*/
    /*<choose>
                <when test="businessType = 0">
    and (businessType = 1 OR businessType = 2)
                </when>
                <otherwise>
    and businessType = #{businessType}
                </otherwise>
            </choose>*/

    /*choose标签是按顺序判断其内部when标签中的test条件出否成立，如果有一个成立，则 choose 结束。
    当 choose 中所有 when 的条件都不满则时，则执行 otherwise 中的sql。*/
}
