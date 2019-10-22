package List.leetcode;

import List.ListNode;

/**
 * 21. 合并两个有序链表
 * 难度：简单
 * 思路：比较值即可，剩下的直接连上
 * **/
public class leetcode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2!=null)
            return l2;
        else if(l1!=null&&l2==null)
            return l1;
        else if(l1==null&&l2==null)
            return null;
        ListNode p=l1,q=l2;
        l1=new ListNode(0);
        l1.next=null;
        ListNode r=l1;
        while(p!=null&&q!=null){
            if(p.val<=q.val)
            {
                r.next=p;
                r=r.next;
                p=p.next;

            }else{
                r.next=q;
                r=r.next;
                q=q.next;
            }
        }
        if(p!=null) r.next=p;
        if(q!=null) r.next=q;
        return l1.next;
    }
}
