package Array;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 二分查找
 * 条件：需要数组是有序的
 * **/
public class Binary_search {
    public static int search(int nums[],int target){
        if(nums.length==0||nums==null)
            return -1;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = new int[]{1,3};
        System.out.println(search(nums, 3));
    }
}
