package List.leetcode;

import List.ListNode;

import java.util.Scanner;

/**
 * 2. 两数相加
 * 难度：中等
 * 思路：记录进位
 * **/
public class leetcode_2 {
    public static int getlength(ListNode head){
        int count=0;
        ListNode cur=head.next;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if(getlength(l1)==0&&getlength(l2)==0)
          return null;
      else if(getlength(l1)!=0&&getlength(l2)==0)
          return helper(l1);
      else if(getlength(l2)!=0&&getlength(l1)==0)
          return helper(l2);
      else
      {
          if(getlength(l1)<getlength(l2)){
              ListNode temp=l1;
              l1=l2;
              l2=temp;
          }
          ListNode p=l1.next,q=l2.next;
          int yushu=0,jinwei=0;
          while(p!=null&&q!=null){
              yushu=(p.val+q.val+jinwei)%10;
              jinwei=(p.val+q.val+jinwei)/10;
              p.val=yushu;
              p=p.next;
              q=q.next;
          }
          while(p!=null){
              yushu=(p.val+jinwei)%10;
              jinwei=(p.val+jinwei)/10;
              p.val=yushu;
              p=p.next;
          }
          if(jinwei>0) {
              ListNode n = new ListNode(jinwei);
              n.next = null;
              p.next = n;
          }
      }
      return l1;
    }

    private static ListNode helper(ListNode l1) {
      ListNode cur=l1.next;
      l1.next=null;
      while(cur!=null){
          ListNode q=new ListNode(cur.val);
          q.next=l1.next;
          l1.next=q;
          cur=cur.next;
      }
      return  l1;

    }

    public static void main(String[] args) {
        //带头节点的
        ListNode head=new ListNode(0);
        head.next=null;
        System.out.println("Input num:");
        Scanner sc=new Scanner(System.in);
        ListNode.createList(head,sc.nextInt());

        ListNode head2=new ListNode(0);
        head2.next=null;
        System.out.println("Input num:");
         sc=new Scanner(System.in);
        ListNode.createList(head2,sc.nextInt());

        ListNode.travel(helper(addTwoNumbers(head,head2)));
    }
}
