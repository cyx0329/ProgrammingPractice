package com.study.interview.genernal.stringManipulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question10Test {

    Question10 q;

    @Before
    public void setUp() throws Exception {
        q = new Question10();
    }

    @Test
    public void replaceCharacter() {
        String input = "Java is the best program language";
        char replace = ' ';
        String replaceTo = "%20";
        String actual = q.replaceCharacter(input, replace, replaceTo);
        assertEquals("Java%20is%20the%20best%20program%20language", actual);
    }

}