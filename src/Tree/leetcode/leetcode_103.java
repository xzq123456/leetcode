package Tree.leetcode;

import Tree.TreeNode;

import java.util.*;

/***
 * 二叉树最大宽度框架的题目集合
 * leetcode 102 二叉树的层次遍历输出 就是利用二叉树的宽度遍历代码 难度：中等
 * leetcode 107. 二叉树的层次遍历 II 从最低层先输出 这个思路就是用栈来保存就可以
 * leetcode 199. 二叉树的右视图 保留层次遍历最右边的数字
 *
 * 103. 二叉树的锯齿形层次遍历
 * 难度：中等
 * 思路：二叉树的求宽度的基础框架改装  判断一下奇数还是偶数层然后用栈或者队列存
 * */
public class leetcode_103 {
    List<List<Integer>> lists=new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        int CurrentSize=0;
        int count=0;
        while(!queue.isEmpty()){
            count++;
            CurrentSize=queue.size();
            List<Integer> list=new ArrayList();
            List<Integer> temp=new ArrayList();
            Stack<Integer> stack=new Stack();
            for(int i=0;i<CurrentSize;i++){
                TreeNode q=queue.poll();
                if(count%2!=0){
                    list.add(q.val);
                }
                else{
                    stack.push(q.val);
                }
                if(q.left!=null)
                    queue.add(q.left);
                if(q.right!=null)
                    queue.add(q.right);
            }
            if(!list.isEmpty())
                lists.add(list);
            if(!stack.isEmpty())
            {
                while(!stack.isEmpty()){
                    temp.add(stack.pop());
                }
                lists.add(temp);
            }
        }
        return lists;
    }
}
