package Tree.leetcode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * 难度：中等
 * 思路：使用队列 curentSize 二叉树的宽度计算框架
 *
 * **/
public class leetcode_102 {
    public  static  List<List<Integer>> lists=new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
      if(root!=null){
          Queue<TreeNode> queue=new LinkedList<>();
          queue.add(root);
          int currentSize=0;
          while(!queue.isEmpty()){
              currentSize=queue.size();
              List<Integer> list=new ArrayList<>();
              for(int i=0;i<currentSize;i++){
                  TreeNode p = queue.poll();
                  list.add(p.val);
                  if(p.left!=null)
                      queue.add(p.left);
                  if(p.right!=null)
                      queue.add(p.right);
              }
              lists.add(list);
          }
          return lists;
      }
      return lists;
    }
    public static void main(String[] args) {
        TreeNode root= TreeNode.createTreeByInput();
        System.out.println(levelOrder(root));
    }
}
