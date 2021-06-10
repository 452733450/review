package com.jack.review.test.stream;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/17/15:54
 */
public class Test01 {

    /*List<CustomerPerson> customerPeopleInsert = getBatchInsertElement(customerPeople, CustomerPerson::getCustomerId, duplicateIds);
    private static <T, R> List<T> getBatchInsertElement (List<T> list, Function<T, R> function, Set<R> duplicateIds) {
        List<T> result = list.stream()
                .filter(item -> !duplicateIds.contains(function.apply(item)))
                .collect(Collectors.toList());
        return result;*/
}
