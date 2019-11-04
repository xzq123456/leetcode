package Tree.leetcode;

import Tree.TreeNode;
/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 难度：简单
 * 思路：递归
 * **/
public class leetcode_112 {
    static boolean flag=false;
    public static void  helper(TreeNode root,int sum,int total){
        if(root==null)
            return;
        sum+=root.val;
        if(root.left==null&&root.right==null&&sum==total){
            flag=true;
            return ;
        }
        helper(root.left,sum,total);
        helper(root.right,sum,total);
        return;
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        helper(root,0,sum);
        return flag;
    }
    public static void main(String[] args) {
        TreeNode root= TreeNode.createTreeByInput();
        System.out.println(hasPathSum(root,3));
    }
}
