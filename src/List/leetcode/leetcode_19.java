package List.leetcode;

import List.ListNode;
import Tree.TreeNode;

import java.util.Scanner;

/**
 * 19. 删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * 难度：中等
 * 思路：找到整数第（链表长度-N）[即倒数第N个节点前面那个节点]
 **/
public class leetcode_19 {
    public static int length(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null) {
            int number = length(head) - n;
            int count = 1;
            ListNode cur = head;
            while (count != number) {
                cur = cur.next;
                count++;
            }
            cur.next = cur.next.next;
            return head;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.println("input data:");
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }


        ListNode.travel2(removeNthFromEnd(ListNode.createList2(arr), 2));
    }
}
