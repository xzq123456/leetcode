package Tree.leetcode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *257. 二叉树的所有路径
 * 难度：简单
 * 思路：
 *   1.如果二叉树中不存在重复的节点，思路就是遍历二叉树，当发现节点是叶子节点的时候，就调用找父节点的函数，存在stack里返回。就是一条路径
 *   2.如果二叉树存在重复节点  思路就是深度优先遍历的（二叉树递归遍历）的思想，使用一个list保存经历的节点，如果是叶子节点，就把list保存的元素记录下来。
 *   记住一点就是递归回去的时候，要从list删除对应的元素，因为list是引用传递，放在堆里；
 *   用String变量就不用删除  第二点的思路和给一个值输出对应和为此值的路径思路基本一致
 */
public class leetcode_257 {
    List<String> list=new ArrayList();
    /*如果二叉树不存在重复节点
    public void travel(TreeNode currentNode, TreeNode root){
        StringBuffer sb=null;
        if(currentNode!=null){
            if(currentNode.left==null&&currentNode.right==null)
            {
                Stack<Integer> stack=new Stack();
                sb=new StringBuffer();
                getpath(root,stack,currentNode.val);
                int size=stack.size();
                for(int i=0;i<size;i++)
                {
                    if(i!=size-1)
                        sb.append(stack.pop()+"->");
                    else
                        sb.append(stack.pop());
                }

            }
            if(sb!=null)
                list.add(sb.toString());
            travel(currentNode.left,root);
            travel(currentNode.right,root);
        }


    }
    public boolean getpath(TreeNode root,Stack<Integer> stack,int val){
        if(root==null)
            return false;
        if(root.val==val){
            stack.push(root.val);
            return true;
        }
        if(getpath(root.left,stack,val)||getpath(root.right,stack,val)){
            stack.push(root.val);
            return true;
        }
        return false;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return list;
        travel(root,root);
        return list;
    }
    */

    /**
     * 如果二叉树存在重复的点
     */
    List<String> liststring=new ArrayList();//最终的结果
    List<List<Integer>> lists=new ArrayList();//存储每一条路径
    public void helper(TreeNode root,ArrayList<Integer> path){
        if(root!=null){
            path.add(root.val);
            ArrayList<Integer>  temp=null;
            if(root.left==null&&root.right==null){
                temp =new ArrayList();
                for(int i=0;i<path.size();i++){
                    temp.add(path.get(i));
                }
                if(temp!=null)
                    lists.add(temp);
            }
            helper(root.left,path);
            helper(root.right,path);
            path.remove(path.size()-1);//重要，别忘了删除
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return liststring;
        ArrayList<Integer> path=new ArrayList();
        helper(root,path);
        StringBuffer sb=null;
        //对得到的路径进行修饰
        for(int i=0;i<lists.size();i++){
            sb=new StringBuffer();
            List<Integer> list=lists.get(i);
            int size=list.size();
            for(int j=0;j<size;j++){
                if(j!=size-1)
                    sb.append(list.get(j)+"->");
                else
                    sb.append(list.get(j));
            }
            if(sb!=null)
                liststring.add(sb.toString());
        }

        return liststring;
    }

}
