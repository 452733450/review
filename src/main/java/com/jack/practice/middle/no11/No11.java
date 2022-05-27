package com.jack.practice.middle.no11;

public class No11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, height[i] * (j - i));
                i++;
            } else {
                maxArea = Math.max(maxArea, height[j] * (j - i));
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        No11 no11 = new No11();
        System.out.println(no11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
