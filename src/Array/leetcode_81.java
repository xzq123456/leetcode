package Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 81. 搜索旋转排序数组 II
 * 难度：中等
 * 思路：本题是在原来的33题加入了重复的元素，可以使用Linkedhashset去重，而不能使用HashSet去重，hashset每次输出和输入不一定一致
 **/
public class leetcode_81 {
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        int nums2[] = new int[set.size()];
        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nums2[i++] = (int) iterator.next();
        }
        for (int j = 0; i < nums2.length; j++)
            System.out.print(nums2[j] + " ");

        int start = 0;
        int end = nums2.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums2[mid] == target) {
                return true;
            }
            //前半部分有序,注意此处用小于等于
            if (nums2[start] <= nums2[mid]) {
                //target在前半部分
                if (target >= nums2[start] && target < nums2[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums2[end] && target > nums2[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 3};
        System.out.println(search(nums, 3));

    }
}
