package Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 由于Scanner和junit不能测试  就只能用main方法测试
 * */
public class client2 {
    public static void main(String[] args) {
        TreeNode root= TreeNode.createTreeByInput();
        TreeNode.MidTravel(root);
    }
}
