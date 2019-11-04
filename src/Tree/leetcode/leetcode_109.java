package Tree.leetcode;

import List.ListNode;
import Tree.TreeNode;

import java.util.Scanner;

import static List.ListNode.createList2;
import static List.ListNode.travel2;

/**
 * 109. 有序链表转换二叉搜索树 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 难度：中等
 * 思路：将链表存入数组中，然后利用创建二叉树的方式来创建
 * **/
public class leetcode_109 {
    public TreeNode helper(int arr[],int start,int end){
        TreeNode root=null;
        if(start<=end){
            int mid=(start+end)/2;
            root=new TreeNode(arr[mid]);
            root.left=helper(arr,start,mid-1);
            root.right=helper(arr,mid+1,end);
        }
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        int count=0;
        ListNode p=head;
        while(p!=null){
            count++;
            p=p.next;
        }
        int[] arr=new int[count];
        p=head;
        int i=0;
        while(p!=null){
            arr[i++]=p.val;
            p=p.next;
        }
        return helper(arr,0,arr.length-1);
    }

}
