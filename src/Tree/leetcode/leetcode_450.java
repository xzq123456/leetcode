package Tree.leetcode;

import Tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * 难度：中等
 * 思路：判断当前节点值小于key，则在右子树中找
 *           当前节点值大于key，则在左子树中找
 *           等于key
 *              1.当前节点没有左子树，那就返回右子树作为新的根
 *              2.当前节点没有右子树，返回左子树作为新的根
 *              3.左右子树都有，就找到右子树最小值对应的节点（保存），然后删除它
 */
public class leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }
    //找到某子树的最小值的节点（一致向左，直到为nullnull）
    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }
    //删除某子树的最小值
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
