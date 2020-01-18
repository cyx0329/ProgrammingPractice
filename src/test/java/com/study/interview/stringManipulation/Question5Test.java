package com.study.interview.stringManipulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question5Test {

    Question5 q;

    @Before
    public void setUp() throws Exception {
        q = new Question5();
    }

    @Test
    public void isOnlyDigitCase1() {
        String s = "123456";
        boolean onlyDigit = q.isOnlyDigit(s);
        assertTrue(onlyDigit);
    }

    @Test
    public void isOnlyDigitCase2(){
        String s = "abcd3456";
        boolean onlyDigit = q.isOnlyDigit(s);
        assertFalse(onlyDigit);
    }
}