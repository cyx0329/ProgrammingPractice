package com.study.interview;

import java.util.HashSet;
import java.util.Set;

public class Question14 {

    public String removeDuplicate(String str){

        if(str == null){
            return null;
        }

        Set<Character> set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
