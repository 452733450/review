package com.jack.review.spring.annotion.requestBody;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/30/9:39
 */
public class principle {
    // https://www.jianshu.com/p/c1b8315c5a03
    /*@RequestBody 用在方法参数上面，用来将请求参数绑定到request body中，通过HttpMessageConverter封装为具体的JavaBean。
    通俗点讲就是你在一个参数上加上该注解，spring就会将request body中的json/xml对象解析成该参数类型的Javabean对象。

    先来看DispatcherServlet。
    作为springMVC处理请求的中央调度器，DispatcherServlet本身是一个servlet，所以我们看doService():
    ->doDispatch()

    请求由DispatcherServlet处理，找到相应的HandlerAdapter进行处理，RequestMappingHandlerAdapter会处理@RequestMapping注解的请求，设置一系列参数解析器进行解析，
    如果参数使用@RequestBody注解，则使用RequestResponseBodyMethodProcessor进行解析，此参数解析器用HttpMessageConverter将HttpMessage封装为具体的JavaBean对象，
    json格式的数据使用AbstractJackson2HttpMessageConverter进行解析，内部使用jackson进行json数据的解析。*/



}
