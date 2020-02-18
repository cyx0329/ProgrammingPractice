package com.study.interview.genernal.stringManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7 {

    public static void main(String[] args){

        String input = "Java";

        System.out.println(findAllVowels(input));

    }

    public static List<Character> findAllVowels(String input){

        List<Character> list = new ArrayList<Character>();

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u'){
                list.add(input.charAt(i));
            }
        }

        return list;
    }
}
