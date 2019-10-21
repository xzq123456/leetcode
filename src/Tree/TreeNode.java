package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public  TreeNode(int val){
        this.val=val;
    }
    public  static  TreeNode createTree(int arr[],int start,int end){
        TreeNode root=null;
        if(start<=end){
            int mid=(start+end)/2;
            root=new TreeNode(arr[mid]);
            root.left=createTree(arr,start,mid-1);
            root.right=createTree(arr,mid+1,end);
        }
        return root;
    }
    public  static  void PreTravel(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            PreTravel(root.left);
            PreTravel(root.right);
        }
    }
    public static  void NondiGuiPreTravel(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p=stack.pop();
            System.out.print(p.val+" ");
            if(p.right!=null)
                stack.push(p.right);
            if(p.left!=null)
                stack.push(p.left);
        }
    }
}
