package com.study.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberUtil {

    public static void main(String[] args){

        List<Integer> list = numberDiviableBy5(25, 175);

        System.out.println(list);
    }

    public static List<Integer> numberDiviableBy5(int start, int end){

        if(start > end){
            int temp;
            temp = start;
            start = end;
            end = temp;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int i = start; i <= end; i++){
            if(i % 5 == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
