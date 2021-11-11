package com.jack.review.util;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 数据库操作结果集
 *
 * @author zhangwei@meix.com
 * @date 2020/11/13
 */
@Data
@Builder
public class DmResult<T> {

    public List<T> needInsertResults;
    public List<T> needDeleteResults;
    public List<T> needUpdateResults;

    /**
     * 只包含 needInsertResults， needDeleteResults
     */
    public static <T, K> DmResult<T> build(List<T> oldObjets, List<T> newObjets, Function<T, K> keyMapper) {
        return build(oldObjets, newObjets, keyMapper, null);
    }

    /**
     * @param bi 用于主键等赋值 : old to new
     */
    public static <T, K> DmResult<T> build(List<T> oldObjets, List<T> newObjets, Function<T, K> keyMapper, BiConsumer<T, T> bi) {

        List<T> needInsertResults = Lists.newArrayList();
        List<T> needUpdateResults = Lists.newArrayList();

        Map<K, T> oldMap = ModelUtils.convertToMap(oldObjets, keyMapper);
        Map<K, T> newMap = ModelUtils.convertToMap(newObjets, keyMapper);
        for (T newObjet : newObjets) {

            K key = keyMapper.apply(newObjet);
            if (!oldMap.containsKey(key)) {
                // 如果旧list中不包含新list中的key（新list中的对象在旧list中不存在的），把新list中的对象放入新增集合

                needInsertResults.add(newObjet);
            } else if (bi != null) {

                T oldObject = oldMap.get(key);
                if (oldObject != null) {

                    bi.accept(oldObject, newObjet);
                    needUpdateResults.add(newObjet);
                }
            }
        }

        // 旧list中过滤掉key在新list中存在的（取出旧list中的在新list中不存在的对象），放入删除集合
        List<T> needDeleteResults = oldObjets.stream()
                .filter(e -> !newMap.containsKey(keyMapper.apply(e)))
                .collect(Collectors.toList());

        return DmResult.<T>builder()
                .needInsertResults(needInsertResults)
                .needDeleteResults(needDeleteResults)
                .needUpdateResults(needUpdateResults)
                .build();
    }

}

