package Stacks_and_Queues;

import java.util.Arrays;
import java.util.Stack;

public class Matching {
    //Solution20. Valid Parentheses: Matching opening and closing bracket
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (c == '(' || c== '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                Character popped = stack.pop();
                if (c == ')' && popped != '(') return false;
                if (c == ']' && popped != '[') return false;
                if (c == '}' && popped != '{') return false;
            }
        }
        return stack.isEmpty(); //*
    }

    //Solution1047. Remove All Adjacent Duplicates in String
    public static String removeDuplicates(String s) {
        if (s.equals("")) return null;

        Stack<Character> stack = new Stack<>(); // the last (most recent) added character is the first one to be deleted.
        stack.push('#');
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString().substring(1);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

}
