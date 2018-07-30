package com.study.interview;

import java.util.Stack;

public class Question4 {

    public String reverseStringIter(String s){

        if(s == null){
            return null;
        }

        if(s.length() == 0){
            return "";
        }

        Stack<Character> stack = new Stack<Character>();
        StringBuilder reverse = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }

        while(!stack.empty()){
            reverse.append(stack.pop());
        }

        return reverse.toString();



    }

    public String reverseStringRe(String s){

        if(s == null){
            return null;
        }

        if(s.length() < 2){
            return s;
        }

        return reverseStringRe(s.substring(1)) + s.charAt(0);

    }
}
