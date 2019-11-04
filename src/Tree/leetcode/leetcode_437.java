package Tree.leetcode;

import Tree.TreeNode;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 难度：简单
 * 思路：和112  113差不多  这个在判断条件上不是叶子节点都行
 * **/
public class leetcode_437 {
    int count=0;
    public void travel(TreeNode root, int sum){
        if(root!=null){
            helper(root,sum,0);
            travel(root.left,sum);
            travel(root.right,sum);
        }
    }
    public void helper(TreeNode root,int sum,int total){
        if(root==null)
            return;
        total+=root.val;
        if(total==sum)
            count++;
        helper(root.left,sum,total);
        helper(root.right,sum,total);
    }
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        travel(root,sum);
        return count;
    }
}

