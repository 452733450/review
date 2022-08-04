package com.jack.practice.simple.no415;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/04/14:37
 */
public class Solution20220804 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            // num1从右往左数，-'0'的目的是让它自动转化为int
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            // num2从右往左数
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // 两个数的位数与进一位的和
            int tmp = n1 + n2 + carry;
            // 计算是否进1
            carry = tmp / 10;
            // 余数作为字符串
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            // 最后算完了 进一位 = 1，则要加上1
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "12345";
        String num2 = "6789";
        System.out.println(new Solution20220804().addStrings(num1, num2));
    }
}
