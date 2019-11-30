package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 224. 基本计算器
 * 难度：困难
 * 思路：中缀表达式求值
 * 两个栈，一个暂存操作数，一个暂存运算符。从左到右，扫描到对应的就入对应的栈。
 * 遇到左括号入运算符栈，遇到运算符就准备入运算符栈，如果栈为空或者栈顶是左括号就直接入栈，
 * 优先级大于栈顶元素则入栈，否则（小于等于）就出栈一个元素，同时从操作数出栈两个元素，第一次出栈的在右边，
 * 运算后结果在入操作数栈，循环比较扫描到的运算符和栈顶的优先级。
 **/
public class leetcode_224 {
    public static int calculate(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('+', 1);
        hashMap.put('-', 1);
        hashMap.put('(', 0);
        hashMap.put(')', 0);
        List<Character> list = new ArrayList<>();
        list.add('+');
        list.add('-');
        list.add(')');
        list.add('(');
        Stack<Integer> stack1 = new Stack<>();//操作数栈
        Stack<Character> stack2 = new Stack<>();//运算符栈
        char[] chars = s.toCharArray();
        //如果就一个数的话 123567，就返回123567
        int j = 0;
        for (j = 0; j < chars.length; ) {
            if (!list.contains(chars[j]) || chars[j] == ' ') {
                j++;
            } else {
                break;
            }
        }
        if (j == chars.length)
            return Integer.parseInt(s.replaceAll(" ", ""));//去空格
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])) {
                if (chars[i] == '(' || stack2.isEmpty()) {
                    stack2.push(chars[i]);
                } else if (hashMap.get(chars[i]) > hashMap.get(stack2.peek())) {
                    stack2.push(chars[i]);
                } else if (chars[i] == ')') {
                    char c = stack2.pop();
                    while (c != '(') {
                        int a = stack1.pop();
                        int b = stack1.pop();
                        int result = 0;
                        if (c == '+')
                            result = b + a;
                        if (c == '-')
                            result = b - a;
                        stack1.push(result);
                        c = stack2.pop();
                    }
                    if (stack2.isEmpty() && i <= chars.length)//栈为空
                        continue;
                } else if (hashMap.get(chars[i]) <= hashMap.get(stack2.peek())) {
                    while (hashMap.get(chars[i]) <= hashMap.get(stack2.peek())) {
                        char c = stack2.pop();
                        int a = stack1.pop();
                        int b = stack1.pop();
                        int result = 0;
                        if (c == '+')
                            result = b + a;
                        if (c == '-')
                            result = b - a;
                        stack1.push(result);
                        if (stack2.isEmpty())
                            break;
                    }
                    stack2.push(chars[i]);
                }
            } else if (chars[i] != ' ')
                stack1.push(Integer.parseInt(String.valueOf(chars[i])));
        }
        while (!stack2.isEmpty()) {
            char c = stack2.pop();
            int a = stack1.pop();
            int b = stack1.pop();
            int result = 0;
            if (c == '+')
                result = b + a;
            if (c == '-')
                result = b - a;
            stack1.push(result);
        }

        return stack1.pop();
    }

    public static void main(String[] args) {
        String s = new String("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate(s));
    }
}
