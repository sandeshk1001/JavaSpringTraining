package Assigments.BasicJavaTask.javaassignment;

import java.util.Stack;

public class Q1 {
    public static void main(String[] args) {
        String s1="{(([[[]]))}";
        System.out.println(check(s1));
    }
    public static boolean check(String s1){
        Stack<Character> stack = new Stack<>();
        if(s1.equals(null)){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) =='(' ||s1.charAt(i) == '{' || s1.charAt(i)=='['){
                stack.push(s1.charAt(i));
                continue;
            }

            char ch;
            switch (s1.charAt(i)){
                case ')':
                    ch=stack.pop();
                    if(ch =='}' || ch==']')
                        return false;
                    break;
                case '}':
                    ch=stack.pop();
                    if(ch ==')' || ch==']')
                        return false;
                    break;
                case ']':
                    ch=stack.pop();
                    if(ch =='}' || ch==')')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
