package com.jack.review.test.stream;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 排序
 * @Auther: Jack You
 * @Date: 2021/05/11/14:38
 */
public class sorted {

    /*sorted，中间操作。有两种排序：

    sorted()：自然排序，流中元素需实现Comparable接口
    sorted(Comparator com)：Comparator排序器自定义排序*/
    public static void main(String[] args) {

    }

    // 将员工按工资由高到低（工资一样则按年龄由大到小）排序
    public static void test(){
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);

    }

    // List<Map<String, Object>>多字段排序
    private List<Map<String, Object>> sortVotedProducts(List<Map<String, Object>> list, Integer shareSortType, Integer valueSortType) {
        /*if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        return list.stream()
                .sorted((v1, v2) -> {
                    // 份额排序
                    BigDecimal b1 = new BigDecimal(v1.get("tradeShare").toString());
                    BigDecimal b2 = new BigDecimal(v2.get("tradeShare").toString());
                    int tradeShare = YesOrNoEnum.YES.getCodeValue().equals(shareSortType) ? b2.compareTo(b1) : b1.compareTo(b2);
                    if (tradeShare != 0) {
                        return tradeShare;
                    }

                    // 市值排序
                    BigDecimal b3 = new BigDecimal(v1.get("holdingEarnings").toString());
                    BigDecimal b4 = new BigDecimal(v2.get("holdingEarnings").toString());
                    int holdingEarnings = YesOrNoEnum.YES.getCodeValue().equals(valueSortType) ? b4.compareTo(b3) : b3.compareTo(b4);
                    if (holdingEarnings != 0) {
                        return holdingEarnings;
                    }

                    // 每个产品的最新交易时间倒序
                    Long l1 = (Long) v1.get("latestTradeApplyTime");
                    Long l2 = (Long) v2.get("latestTradeApplyTime");
                    int tmp = l2.compareTo(l1);
                    if (tmp != 0) {
                        return tmp;
                    }

                    // 产品id倒序
                    Long l3 = (Long) v1.get("productId");
                    Long l4 = (Long) v2.get("productId");
                    return l4.compareTo(l3);
                })
                .collect(Collectors.toList());*/
        return null;
    }
}
