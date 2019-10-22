package List;

import java.util.Scanner;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val){
        this.val=val;
    }
    public static void  createList(ListNode head,int num){
        System.out.println("input data:");
        Scanner sc=new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        ListNode r=head;
        for(int i=0;i<num;i++){
            ListNode p=new ListNode(Integer.parseInt(s[i]));
//            尾插法
            p.next=null;
            r.next=p;
            r=r.next;
//            头插法
//            p.next=head.next;
//            head.next=p;
        }
    }
    //没有头节点的链表
    public static ListNode createList2(int a[]){
        ListNode head=null;
        ListNode cur=null;
        if(a.length>0){
            for(int i=0;i<a.length;i++){
                ListNode p=new ListNode(a[i]);
                p.next=null;
                if(i==0){
                    head=cur=p;
                }
                else{
                    cur.next=p;
                    cur=cur.next;
                }
            }
        }
        return head;
    }
    public static void travel(ListNode head){
        ListNode cur=head.next;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
    //遍历没有头节点的
    public static void travel2(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    public static void main(String[] args) {
//        ListNode head=new ListNode(0);
//        head.next=null;
//        System.out.println("Input num:");
//        Scanner sc=new Scanner(System.in);
//        ListNode.createList(head,sc.nextInt());
//        travel(head);


        //创建没有头节点
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[5];
        System.out.println("input data:");
        String[] s = sc.nextLine().split(" ");
        for(int i=0;i< arr.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        travel2(createList2(arr));
    }
}
