package com.jack.review.test.redis.lock;

import java.util.UUID;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/01/14:06
 */
public class MainClass {
    //产品排序序号，采用redis分布式锁，该锁非续命锁
    private static final String PRODUCT_REDIS_LOCK = "product_redis_lock";
    //超时时间
    private static final long LOCK_TIME = 10000;
    public static void main(String[] args) {
        String redis_lock = UUID.randomUUID().toString();
        RedisLock.tryLock(PRODUCT_REDIS_LOCK, redis_lock, LOCK_TIME);
        /*ProductCreateResult result = ProductBuilder.build4Create(productDetailReq, managerUserMap, sysProductSettingRsp, companyCode);

        // 入库
        productMapper.insertSelective(result.getNeedInsertProduct());*/
        RedisLock.releaseLock(PRODUCT_REDIS_LOCK, redis_lock);

    }
}
