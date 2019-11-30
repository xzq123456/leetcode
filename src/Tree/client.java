package Tree;

import org.junit.Before;
import org.junit.Test;

public class client {
    int arr[];
    TreeNode root;

    @Before
    public void init() {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    }

    @Test
    public void testinit() {
        init();
        root = TreeNode.createTree(arr, 0, arr.length - 1);
//        TreeNode.PreTravel(root);
//        System.out.println();
//        TreeNode.NondiGuiPreTravel(root);
        TreeNode.NonDiGuiMidTravel(root);
    }


}
