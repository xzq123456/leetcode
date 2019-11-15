package Stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 难度：简单
 * 思路：使用辅助站，辅助栈顶元素是最小值
 *得到最小值的时间复杂度为O(1)  空间复杂度为O(N)
 * **/
public class leetcode_155 {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public leetcode_155() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }
}
