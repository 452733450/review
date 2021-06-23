package com.jack.review.test.mysql;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/23/14:29
 */
public class cdata {
    /*在使用mybatis 时我们sql是写在xml 映射文件中，如果写的sql中有一些特殊的字符的话，
    在解析xml文件的时候会被转义，但我们不希望他被转义，所以我们要使用<![CDATA[ ]]>来解决。*/
//    <![CDATA[   ]]> 是什么，这是XML语法。在CDATA内部的所有内容都会被解析器忽略。
//    如果文本包含了很多的"<"字符 <=和"&"字符——就象程序代码一样，那么最好把他们都放到CDATA部件中。
}
