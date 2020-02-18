package com.study.interview.leetCode;

import java.util.Stack;

//https://leetcode.com/problems/reverse-string/description/

public class ReverseString {

    public String reverseString(String s) throws IllegalArgumentException{
        Stack<Character> stack = new Stack<Character>();
        if(s == null) {
           return null;
        }
        if(s.length() > 8){
            throw new IllegalArgumentException("String s is too long.");
        }

        for(int i = 0; i <= s.length()-1; i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder n = new StringBuilder();
        while(!stack.empty()) {
            n.append(stack.pop());
        }
        return n.toString();
    }
}
