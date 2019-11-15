package Tree.leetcode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 求根到叶子节点数字之和
 * 难度：中等
 * leetcode 257. 二叉树的所有路径还是用到找二叉树找路径的方法
 * 思路：先找到叶子节点，然后调用算法找到根节点到叶子节点的路径，保存到集合中
 * **/

public class leetcode_129 {
    public  static List<List<Integer>> lists=new ArrayList<>();

    /**
     *
     * @param root 根节点
     * @param stack 栈来保存根节点到指定叶子节点的路径
     * @param val 指定的根节点值
     * @return
     */
    public static boolean helper(TreeNode root,Stack<Integer> stack,int val){
         if(root!=null){
             if(root.val==val) {
                 stack.push(root.val);
                 return true;
             }
             if(helper(root.left,stack,val)||helper(root.right,stack,val)){
                 stack.push(root.val);
                 return true;
             }
         }
         return false;
    }

    /**
     *
     * @param root
     * @param p  永远指向树的根节点，因为必须从根到叶子节点，递归遍历的话孩子节点也会变成根节点的，所以要用一个变量来保存
     */
    public static void travel(TreeNode root,TreeNode p){
     if(root!=null){
         if(root.left==null&&root.right==null)
         {  Stack<Integer> stack=new Stack<>();
             helper(p,stack,root.val);
             List<Integer> list=new ArrayList<>();
             while(!stack.isEmpty()){
                 list.add(stack.pop());
             }
             lists.add(list);
         }
         travel(root.left,p);
         travel(root.right,p);
     }
    }
    public static int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        TreeNode p=root;
        travel(root,p);
        int sum=0;
        for(List<Integer> list:lists){
            for(int i=0,j=list.size()-1;i<list.size();i++,j--){
                sum= (int) (sum+list.get(i)*Math.pow(10.0,j));
            }
        }
        return sum;
    }
    public static void main(String[] args) {
//        TreeNode root= TreeNode.createTreeByInput();
//        System.out.println(sumNumbers(root));

    }
}
