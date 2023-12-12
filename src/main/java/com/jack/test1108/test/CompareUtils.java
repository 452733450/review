package com.jack.test1108.test;

import com.google.common.collect.Maps;
import com.jack.review.util.ModelUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareUtils {

    public static Map<String, Map<String, Object>> compareFields(Object obj1, Object obj2, List<String> compareProperties) {
        try {
            //装返回值得
            Map<String, Map<String, Object>> map = new LinkedHashMap<>();
            // 只有两个对象都是同一类型的才有可比性
            if (obj1.getClass() == obj2.getClass()) {
                // 获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(obj1.getClass(),
                        Object.class).getPropertyDescriptors();
                // 这里就是所有的属性了
                for (PropertyDescriptor pd : pds) {
                    // 属性名
                    String name = pd.getName();
                    Method method = pd.getWriteMethod();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    // 参数类型
                    String parameterType = parameterTypes[0].getName();

                    // 如果当前属性选择进行比较，跳到下一次循环
                    if (compareProperties != null && compareProperties.contains(name)) {
                        // get方法
                        Method readMethod = pd.getReadMethod();
                        // 在obj1上调用get方法等同于获得obj1的属性值
                        Object objBefore = readMethod.invoke(obj1);
                        // 在obj2上调用get方法等同于获得obj2的属性值
                        Object objAfter = readMethod.invoke(obj2);


                        if ((objBefore == null || "[]".equals(objBefore) || "".equals(objBefore)) && objAfter == null) {
                            continue;
                        } else if (objBefore == null) {
                            if (objAfter instanceof Collection && ((Collection) objAfter).size() == 0) {
                                continue;
                            }
                            Map<String, Object> m = new LinkedHashMap<>();
                            m.put("objBefore", objBefore);
                            m.put("objAfter", objAfter);
                            map.put(name, m);
                            continue;
                        }
                        // 比较这两个值是否相等,不等则放入map
                        if (!objBefore.equals(objAfter)) {
                            Map<String, Object> m = new LinkedHashMap<>();
                            m.put("objBefore", objBefore);
                            m.put("objAfter", objAfter);
                            map.put(name, m);
                        }
                    }
                }
            } else {
                System.out.println("对象类型不一致，不能完成对比");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
            return null;
        }
    }

    public static void main(String[] args) {
        // 系统登记的字段
        List<Col> colListFromSys = new ArrayList<>();
        Map<String, String> colListFromSysMap = convertToMap(colListFromSys, Col::getColName, Col::getColType);
        // 实际表中的字段
        List<Col> colListFromReal = new ArrayList<>();
        Map<String, String> colListFromRealMap = convertToMap(colListFromReal, Col::getColName, Col::getColType);

        // 未登记的字段
        List<Col> unregisteredProperties = new ArrayList<>();
        // 字段名或类型不一致的字段
        List<Col> differentProperties = new ArrayList<>();
        // 比较实际表字段名或类型是否和系统登记的一致，且是否有未登记的字段,以系统登记字段为准
        if (CollectionUtils.isEmpty(colListFromSys)) {
            // 系统登记的字段为空,没必要继续比较了
            System.out.println("系统登记的字段为空");
            return;
        }
        if (CollectionUtils.isEmpty(colListFromReal)) {
            // 实际表中的字段为空
            System.out.println("实际表中的字段为空");
            // 未登记的字段就是系统登记的字段
            unregisteredProperties.addAll(colListFromSys);
            return;
        }

        // 遍历colListFromSysMap
        for (Map.Entry<String, String> entry : colListFromSysMap.entrySet()) {
            String colName = entry.getKey();
            String colType = entry.getValue();
            // 如果实际表中的字段名和系统登记的字段名不一致或者字段类型不一致，就放入differentProperties
            if (!colListFromRealMap.containsKey(colName) || !colListFromRealMap.get(colName).equals(colType)) {
                differentProperties.add(new Col(colName, colType));
            }
            // 如果不存在，就放入unregisteredProperties
            if (!colListFromRealMap.containsKey(colName)) {
                unregisteredProperties.add(new Col(colName, colType));
            }
        }
        System.out.println("未登记的字段：" + unregisteredProperties);
        System.out.println("字段名和类型不一致的字段：" + differentProperties);

    }

    public static <T, K, V> Map<K, V> convertToMap(Collection<T> collection, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .filter(e -> e != null && keyMapper.apply(e) != null)
                .collect(Collectors.toMap(keyMapper, valueMapper, (a, b) -> a));
    }
}
