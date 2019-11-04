package List.leetcode;

import List.ListNode;

import java.util.Scanner;

import static List.ListNode.createList2;
import static List.ListNode.travel2;

/**
 * 148. 排序链表
 * 难度：中等 要求时间复杂度为nlogn
 * 思路:快速排序
 * **/
public class leetcode_148 {
    public static void quicksort(int arr[], int low, int high) {
        if (low > high)
            return;
        int i = low, j = high;
        int temp = arr[low];
        while (i < j) {
            while (i < j && arr[j] > temp) --j;
            if (i < j) {
                arr[i] = arr[j];
                ++i;
            }
            while (i < j && arr[i] <= temp) ++i;
            if (i < j) {
                arr[j] = arr[i];
                --j;
            }
            arr[i] = temp;
            quicksort(arr, low, i - 1);
            quicksort(arr, i + 1, high);
        }
    }
        public static ListNode sortList (ListNode head){
            if (head == null)
                return null;
            int count = 0;
            ListNode p = head;
            while (p != null) {
                count++;
                p = p.next;
            }
            int arr[] = new int[count];
            p = head;
            int i = 0;
            while (p != null) {
                arr[i++] = p.val;
                p = p.next;
            }
            quicksort(arr, 0, arr.length - 1);
            p = head;
            for (int j = 0; j < arr.length; j++) {
                p.val = arr[j];
                p = p.next;
            }
            return head;
        }

        public static void main (String[] args){
            Scanner sc = new Scanner(System.in);
            int arr[] = new int[5];
            System.out.println("input data:");
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            ListNode head = createList2(arr);
            sortList(head);
            travel2(head);

        }

}
