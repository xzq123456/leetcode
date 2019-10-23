package Tree.leetcode;

import Tree.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 难度：中等
 * 思路：递归创建，注意范围
 * **/
public class leetcode_105 {
    public static  TreeNode helper(int pre[],int L1,int R1,int in[],int L2,int R2){
        if(L1>R1||L2>R2)
            return null;
        TreeNode root=new TreeNode(pre[L1]);
        for(int i=L2;i<in.length;i++){
            if(in[i]==pre[L1]){
                root.left=helper(pre,L1+1,L1+i-L2,in,L2,i-1);
                root.right=helper(pre,L1+i-L2+1,R1,in,i+1,R2);
                break;
            }
        }
        return root;
    }
    public static  TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
            return null;
        return  helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static void main(String[] args) {
        int preorder[]=new int[]{4,2,1,3,6,5};
        int inorder[]=new int[]{1,2,3,4,5,6};
        TreeNode root=buildTree(preorder,inorder);
        TreeNode.MidTravel(root);
    }
}
