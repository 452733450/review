package com.jack.review.test.redis;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/19/13:40
 */
public class SaveList {

    /*存
    public void setKeyValueExpire(String key, String value, int expire, TimeUnit timeUnit) {
        this.stringRedisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    取
    public String getByKey(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    redisUtil.setKeyValueExpire(key, JSON.toJSON(needExportCustomers).toString(), 7200, TimeUnit.SECONDS);

    String businessJsonArray = redisUtil.getByKey(key);
        if(businessJsonArray == null){
        throw new ServiceException("新的客户名单已过期，请重新上传认申赎确认信息!");
    }
        return JSONObject.parseArray(businessJsonArray, UploadCustomerData.class);*/
}
