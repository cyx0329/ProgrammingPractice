package com.study.interview.genernal.stringManipulation;

import java.util.regex.Pattern;

public class Question5 {

    public boolean isOnlyDigit(String s){

        String pattern = "\\d+";
        Pattern p = Pattern.compile(pattern);
        return p.matcher(s).matches();
    }
}
