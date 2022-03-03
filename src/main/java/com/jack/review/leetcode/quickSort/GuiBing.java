package com.jack.review.leetcode.quickSort;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/03/17:52
 */
public class GuiBing {
    //归并排序
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);

    }
    public int[] mergeSort(int[] nums, int left, int right){
        //递归退出条件
        //如果左指针大于右指针，就退出循环
        //经过左右拆分，数组元素形成单个元素的树
        if(left >=right){
            return nums;
        }
        //数组中的中位数
        int mid = (right+left)/2;
        //数组左拆分
        mergeSort(nums, left, mid);
        //数组右拆分
        mergeSort(nums, mid+1, right);
        //数组合并，将单个元素进行合并
        return merge(nums, left, mid, right);
    }
    public int[] merge(int[] nums, int left, int mid, int right){
        //定义一个临时数组，存储排序好的元素
        int[] temp = new int[right-left+1];
        //左排序的元素数组的左指针
        int i = left;
        //右排序的元素数组的左指针
        int j = mid+1;
        //定义一个指向临时数组的左指针
        int t = 0;
        //循环判断条件
        //左数组到mid，右数组到right
        //左右数组都有元素的时候，进行比较
        while(i<=mid&&j<=right){
            //取左右数组中较小的元素，填入临时数组中
            //并将较小元素所在数组的左指针和临时数组的左指针都一起右移
            if(nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }
        //当左右数组其中一个数组没有元素的时候
        //如果左数组中还有剩余元素，就将剩余元素全部加入到临时数组中
        while(i<=mid){
            temp[t++]=nums[i++];
        }
        //如果有数组中还有元素，就将剩余元素全部加入到临时数组中
        while(j<=right){
            temp[t++] = nums[j++];
        }
        //将临时数组的元素复制到原数组中去
        for(int k = 0; k<temp.length;k++){
            //特别注意这便nums数组起始位置要从 k+left开始
            //原因在加右数组的时候，起始位置要加left
            //这里不理解，直接把它记住。
            nums[left+k]=temp[k];
        }
        //返回原数组
        return nums;
    }
}
