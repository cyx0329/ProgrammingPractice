package com.study.interview.genernal.stringManipulation;

import com.study.interview.genernal.stringManipulation.stringManipulation.Question14;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question14Test {

    Question14 question14;

    @Before
    public void setUp() throws Exception {
        question14 = new Question14();
    }

    @Test
    public void removeDuplicate() {
        String str = "bananas";
        String actual = question14.removeDuplicate(str);
        assertEquals("bans", actual);
    }
}