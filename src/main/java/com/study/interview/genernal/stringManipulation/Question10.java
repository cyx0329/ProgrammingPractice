package com.study.interview.genernal.stringManipulation;

public class Question10 {

    public String replaceCharacter(String input, char replace, String replaceTo){

        if(input == "" || input == null){
            return null;
        }

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == replace){
                output.append(replaceTo);
            }
            else{
                output.append(input.charAt(i));
            }

        }
        return output.toString();
    }
}
