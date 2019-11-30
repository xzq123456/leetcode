package Tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * leetcode 117一样，不过leetcode116是完美二叉树，117是普通二叉树
 * 难度：中等
 * 思路：二叉树求宽度框架  得到每一层的元素，然后遍历赋next指针就行
 **/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class leetcode_116 {
    List<List<Node>> lists = new ArrayList();

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int currentSize = 0;
        while (!queue.isEmpty()) {
            currentSize = queue.size();
            List<Node> list = new ArrayList();
            for (int i = 0; i < currentSize; i++) {
                Node q = queue.poll();
                list.add(q);
                if (q.left != null)
                    queue.add(q.left);
                if (q.right != null)
                    queue.add(q.right);
            }
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Node> list = lists.get(i);
            if (list.size() == 1)
                list.get(0).next = null;
            for (int j = 0; j < list.size() - 1; j++) {
                list.get(j).next = list.get(j + 1);
            }
        }
        return root;

    }
}
