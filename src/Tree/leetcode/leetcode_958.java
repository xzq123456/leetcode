package Tree.leetcode;

import Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给定一个二叉树，确定它是否是一个完全二叉树。
 * 难度：中等
 * 思路：空指针也入队，当检测到空指针时候，如果是完全二叉树，那么后面都应该是叶子节点
 * **/
public class leetcode_958 {
    public static boolean isCompleteTree(TreeNode root) {
       if(root==null)
           return false;
       Queue<TreeNode> queue=new LinkedList<>();
       queue.add(root);
       boolean flag=false;
       while(!queue.isEmpty()){
           TreeNode q=queue.poll();
           if(q==null){
               flag=true;
               continue;
           }
           if(flag)
               return false;
           queue.add(q.left);
           queue.add(q.right);
       }
       return  true;
    }
    public static void main(String[] args) {
        TreeNode root=TreeNode.createTreeByInput();
        System.out.println(isCompleteTree(root));
    }
}
