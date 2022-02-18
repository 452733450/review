package com.jack.review.test.stream;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/02/18/15:34
 */
public class SortTest {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("latestTradeApplyTime", new Date().getTime());
        map.put("productId", 1L);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("productId", 2L);


        list.add(map2);
        list.add(map);
        List<Map<String, Object>> res = sortVotedProducts(list, null, null);
        System.out.println(res);
    }

    private static List<Map<String, Object>> sortVotedProducts(List<Map<String, Object>> list, Integer shareSortType, Integer valueSortType) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        return list.stream()
                .sorted((v1, v2) -> {
                    if(shareSortType != null) {
                        // 份额排序
                        BigDecimal b1 = new BigDecimal(v1.get("tradeShare").toString().replaceAll(",", ""));
                        BigDecimal b2 = new BigDecimal(v2.get("tradeShare").toString().replaceAll(",", ""));
                        int tradeShare = b1.compareTo(b2);
                        if (tradeShare != 0) {
                            return tradeShare;
                        }
                    }

                    if (valueSortType != null) {
                        // 市值排序
                        Object referenceValue1 = v1.get("referenceValue");
                        String str1 = referenceValue1 != null ? referenceValue1.toString() : "0";
                        Object referenceValue2 = v2.get("referenceValue");
                        String str2 = referenceValue2 != null ? referenceValue2.toString() : "0";
                        BigDecimal b3 = new BigDecimal(str1.replaceAll(",", ""));
                        BigDecimal b4 = new BigDecimal(str2.replaceAll(",", ""));
                        int holdingEarnings = b3.compareTo(b4);
                        if (holdingEarnings != 0) {
                            return holdingEarnings;
                        }
                    }

                    // 每个产品的最新交易时间倒序
                    Long l1 = v1.get("latestTradeApplyTime") != null ? (Long) v1.get("latestTradeApplyTime") : 0L;
                    Long l2 = v2.get("latestTradeApplyTime") != null ? (Long) v2.get("latestTradeApplyTime") : 0L;
                    int tmp = l2.compareTo(l1);
                    if (tmp != 0) {
                        return tmp;
                    }

                    // 产品id倒序
                    Long l3 = (Long) v1.get("productId");
                    Long l4 = (Long) v2.get("productId");
                    return l4.compareTo(l3);
                })
                .collect(Collectors.toList());
    }
}
