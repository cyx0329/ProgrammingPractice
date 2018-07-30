package com.study.interview;

import java.util.Arrays;
import java.util.List;

public class Question12 {

    public String reverseSentence(String sentence){

        if(sentence == "" || sentence == null){
            return null;
        }

        List<String> list = Arrays.asList(sentence.split("\\s"));
        StringBuilder output = new StringBuilder();
        for(int i = list.size()-1; i >= 0; i--){
            output.append(list.get(i));
            output.append(" ");
        }

        return output.toString().trim();

    }
}
