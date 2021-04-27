package com.study.interview.genernal;

import java.util.LinkedList;

public class SlidingWindowFollowUp {
    private LinkedList<Integer> list;
    private int product;
    private int lastIndexofZero;
    private int count;

    public SlidingWindowFollowUp() {
        list = new LinkedList<>();
        lastIndexofZero = -1;
        product = 1;
    }

    public void add(int val) {
        if(val == 0) {
            lastIndexofZero = count;
            if(count-1>0){
                list.add(list.get(count-1));
            } else {
                list.add(1);
            }

        } else {
            if(count-1>0){
                list.add(list.get(count-1)*val);
            } else {
                list.add(val);
            }

        }
        count++;
    }

    public int getProduct(int k ) {
        if(lastIndexofZero <  count-k) {
            return list.get(count-1)/list.get(count-k-1);
        }
        return 0;
    }
}
