package com.study.interview.stringManipulation;

import com.study.interview.stringManipulation.Question1;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class Question1Test {

    Question1 q;

    @Before
    public void setUp() throws Exception{
        q = new Question1();
    }

    @Test
    public void returnDuplicateCase1() {
        String s = "Java";
        Map<Character, Integer> map = q.returnDuplicate(s);
        assertTrue(map.get('a') == 2);
    }

    @Test
    public void returnDuplicateCase2() {
        String s = "Nick";
        Map<Character, Integer> map = q.returnDuplicate(s);
        assertTrue(map.size() == 0);
    }
}