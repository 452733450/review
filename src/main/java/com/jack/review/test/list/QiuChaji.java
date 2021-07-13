package com.jack.review.test.list;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/28/9:06
 */
public class QiuChaji {
    //    根据account 和 groupid 是否相同求差集
// groupPeopleList - dbaGroupPeoples 差集
    /*List<GroupPeople> distinctByUniqueList = groupPeopleList.stream()
            .filter(item -> !dbaGroupPeoples.stream().map(e -> e.getAccount() + e.getGroupId()).collect(Collectors.toList()).contains(item.getAccount() + item.getGroupId()))
            //去重
            .filter(UniqueUtils.distinctByKey(e -> e.getAccount())).peek(e -> e.setId(UUIDUtil.uuid())).collect(Collectors.toList());*/

    /**
     * @方法描述：获取两个ArrayList的差集
     * @param firstArrayList 第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 差集ArrayList
     */
    /*public static List<IncomeInvResponse> receiveDefectList(List<IncomeInvResponse> firstArrayList,
                                                            List<InvoiceDetailDO> secondArrayList) {
        List<IncomeInvResponse> resultList = firstArrayList.stream()
                .filter(item -> !secondArrayList.stream().map(e -> e.getInvoiceCode() + "|" + e.getInvoiceNum())
                        .collect(Collectors.toList()).contains(item.getInvoiceCode() + "|" + item.getInvoiceNr()))
                .collect(Collectors.toList());
        return resultList;
    }*/
    public static void main(String[] args) {
        List<User> users = test();
        System.out.println(users);
    }

    private static List<User> test() {
        List<User> userList1 = Lists.newArrayList(new User(1, 2), new User(2, 3), new User(3, 4));
        List<User> userList2 = Lists.newArrayList(new User(3, 4), new User(2, 3), new User(5, 6));
        return userList1.stream()
                .filter(user -> !userList2.stream().map(user2 -> user2.getCustomerId() + "_" + user2.getProductId()).collect(Collectors.toList()).contains(user.getCustomerId() + "_" + user.getProductId()))
                .collect(Collectors.toList());
    }
}
