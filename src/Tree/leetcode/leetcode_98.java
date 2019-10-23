package Tree.leetcode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 难度：中等
 * 思路：中序遍历二叉树得到的序列保存在集合中，在判断这个集合式不是升序的
 * **/
public class leetcode_98 {
    //中序遍历二叉树，看是否有序
    public  static List<Integer> list=new ArrayList();
    public static  void travel(TreeNode root){
        if(root!=null){
            travel(root.left);
            list.add(root.val);
            travel(root.right);
        }
    }
    public static  boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        travel(root);
        boolean flag=true;
        for(int i=0;i<list.size()-1;i++)
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)>=list.get(j))
                    flag=false;
            }
        return flag;

    }
    public static void main(String[] args){
        TreeNode root= TreeNode.createTreeByInput();
        TreeNode.cengci(root);
        System.out.println(isValidBST(root));
    }
}
