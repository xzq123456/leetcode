package Tree.leetcode;

import Tree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 难度：困难
 * 思路：
 * 二叉树 abc，a 是根结点（递归中的 root），bc 是左右子结点（代表其递归后的最优解）。
 * 最大的路径，可能的路径情况：
 *
 *     a
 *    / \
 *   b   c
 *
 *     b + a + c。
 *     b + a + a 的父结点。
 *     a + c + a 的父结点。
 *
 * 其中情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。
 * 这种情况是没法递归的，但是结果有可能是全局最大路径和。
 * 情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回，也就是上面说的递归后的最优解啦。
 *
 * 另外结点有可能是负值，最大和肯定就要想办法舍弃负值（max(0,x)）（max(0, x)）（max(0,x)）。
 * 但是上面 3 种情况，无论哪种，a 作为联络点，都不能够舍弃。
 *
 * **/
public class leetcode_124 {
    int val=Integer.MIN_VALUE;
    public int helper(TreeNode  root)
    {
        if (root == null) return 0;
        int left =  helper(root.left);
        int right =  helper(root.right);
        int lmr = root.val + Math.max(0, left) +Math.max(0, right);//情况一
        int ret = root.val + Math.max(0, Math.max(left, right));//情况2和3
        val = Math.max(val, Math.max(lmr, ret));
        return ret;
    }

    public int maxPathSum(TreeNode root)
    {
        helper(root);
        return val;
    }

}
