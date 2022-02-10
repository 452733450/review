package com.jack.review.util;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/12/08/16:33
 */

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;


public class CompareFieldsUtil {

    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个list分别存obj1,obj2此属性名的值
     *
     * @param obj1       进行属性比较的对象1
     * @param obj2       进行属性比较的对象2
     * @param compareArr 选择要比较的属性数组
     * @return 属性差异比较结果map
     */
    public static Map<String, Map<String, Object>> compareFields(Object obj1, Object obj2, String[] compareArr) {
        try {
            //装返回值得
            Map<String, Map<String, Object>> map = new LinkedHashMap<>();
            //需要对比的字段list
            List<String> ignoreList = null;
            if (compareArr != null && compareArr.length > 0) {
                // array转化为list
                ignoreList = Arrays.asList(compareArr);
            }
            // 只有两个对象都是同一类型的才有可比性
            if (obj1.getClass() == obj2.getClass()) {
                // 获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(obj1.getClass(),
                        Object.class).getPropertyDescriptors();
                // 这里就是所有的属性了
                for (PropertyDescriptor pd : pds) {
                    // 属性名
                    String name = pd.getName();
                    // 如果当前属性选择进行比较，跳到下一次循环
                    if (ignoreList != null && ignoreList.contains(name)) {
                        // get方法
                        Method readMethod = pd.getReadMethod();
                        // 在obj1上调用get方法等同于获得obj1的属性值
                        Object objBefore = readMethod.invoke(obj1);
                        // 在obj2上调用get方法等同于获得obj2的属性值
                        Object objAfter = readMethod.invoke(obj2);
                        if (objBefore instanceof Timestamp) {
                            objBefore = new Date(((Timestamp) objBefore).getTime());
                        }
                        if (objAfter instanceof Timestamp) {
                            objAfter = new Date(((Timestamp) objAfter).getTime());
                        }
                        if (objBefore == null && objAfter == null) {
                            continue;
                        } else if (objBefore == null) {
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
            System.out.println("错误");
            return null;
        }
    }


    /**
     * 比较对象属性值不同
     *
     * @param obj1      进行属性比较的对象1
     * @param obj2      进行属性比较的对象2
     * @param ignoreArr 选择忽略比较的属性数组
     * @return 属性差异比较结果 map
     */
    /*@SuppressWarnings("rawtypes")
    public static List<String> compareFields2(Object obj1, Object obj2, String[] ignoreArr) {
        try {
            List<String> returnList = Lists.newArrayList();
            List<String> ignoreList = null;
            if (ignoreArr != null && ignoreArr.length > 0) {
                ignoreList = Arrays.asList(ignoreArr);
            }
            if (obj1.getClass() == obj2.getClass()) { //只有两个对象都是同一类型才有可比性
                Class clazz = obj1.getClass();
                //获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    if (ignoreList != null && ignoreList.contains(name)) {
                        continue;
                    }
                    Method readMethod = pd.getReadMethod();//获取属性的get方法
                    //在obj1上调用get方法等同于获得obj1的属性值
                    Object o1 = readMethod.invoke(obj1);
                    //在obj2上调用get方法等同于获得obj2的属性值
                    Object o2 = readMethod.invoke(obj2);
                    //如果此属性是时间
                    if (o1 instanceof Timestamp) {
                        o1 = new Date(((Timestamp) o1).getTime());
                    }
                    if (o2 instanceof Timestamp) {
                        o2 = new Date(((Timestamp) o2).getTime());
                    }
                    if (o1 == null && o2 == null) {
                        continue;
                    } else if (o1 == null && o2 != null) {
                        //不一致
                        returnList.add(String.valueOf(name));
                        continue;
                    }
                    if (!o1.equals(o2)) {
                        returnList.add(String.valueOf(name));
                    }
                }
            }
            return returnList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    static class User implements Serializable {
        private Integer age;
        private String name;

        public User(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        User user1 = new User(1, "jack");
        User user2 = new User(null,"tom");
        Map<String, Map<String, Object>> map = compareFields(user1,user2,new String []{"age", "name"});
        System.out.println(map.size());
    }

}

