package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 难度：中等
 * 思路：从左到右扫描，扫描到操作数就入栈，扫描到运算符就出栈两个元素，第一次出栈元素在右，结合运算符进行运算，将计算的结果入栈
 * **/
public class leetcode_150 {
    public static  int calculate(int a,int b,String s){
        if(s.equals("+"))
            return a+b;
        else if(s.equals("-"))
            return a-b;
        else if(s.equals("*"))
            return a*b;
        else
            return a/b;

    }
    public  static  int evalRPN(String[] tokens) {
        List<String> ops=new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for(int i=0;i<tokens.length;i++){
            if(ops.contains(tokens[i])){
                int a=stack.pop();
                int b=stack.pop();
                 result=calculate(b,a,tokens[i]);
                 stack.push(result);
            }
           else
               stack.push(Integer.parseInt(tokens[i]));
        }
        return result;
    }
    public static void main(String[] args) {

      String [] tokens=new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
        Stack stack=new Stack();
    }
}
