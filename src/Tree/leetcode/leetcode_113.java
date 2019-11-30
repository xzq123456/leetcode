package Tree.leetcode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 难度：中等
 * 思路:在112的基础上存储路径
 **/
public class leetcode_113 {
    List<List<Integer>> lists = new ArrayList();

    public void helper(TreeNode root, int total, int sum, ArrayList<Integer> list) {
        if (root == null)
            return;
        total += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && total == sum) {
            List<Integer> temp = new ArrayList();//临时的集合存储一条路径
            for (int i = 0; i < list.size(); i++)
                temp.add(list.get(i));
            lists.add(temp);
        }
        helper(root.left, total, sum, list);
        helper(root.right, total, sum, list);

        list.remove(list.size() - 1);//list存在堆里，在递归过程不会像栈中元素回到上一次的位置
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return lists;
        ArrayList<Integer> list = new ArrayList();
        helper(root, 0, sum, list);
        return lists;
    }
}

